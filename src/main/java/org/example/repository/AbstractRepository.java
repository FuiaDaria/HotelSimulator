package org.example.repository;

import org.example.utils.DatabaseConnectionFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractRepository<T> {

    protected static final Logger LOGGER = Logger.getLogger(AbstractRepository.class.getName());
    protected final Class<T> type;

    protected AbstractRepository() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private String createSelectQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" * ");
        sb.append("FROM ");
        sb.append(type.getSimpleName());

        return sb.toString();
    }

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" * ");
        sb.append("FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " = ?");

        return sb.toString();
    }

    public ArrayList<T> get() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String query = createSelectQuery();

        try {
            connection = DatabaseConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            return (ArrayList<T>) createObjects(resultSet);
        } catch (SQLException sqlException) {
            LOGGER.log(Level.WARNING, type.getName() + sqlException.getMessage());
        } finally {
            DatabaseConnectionFactory.close(resultSet);
            DatabaseConnectionFactory.close(statement);
            DatabaseConnectionFactory.close(connection);
        }

        return null;
    }

    public T getById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String query = createSelectQuery(type.getDeclaredFields()[0].getName());

        try {
            connection = DatabaseConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException sqlException) {
            LOGGER.log(Level.WARNING, type.getName() + sqlException.getMessage());
        } finally {
            DatabaseConnectionFactory.close(resultSet);
            DatabaseConnectionFactory.close(statement);
            DatabaseConnectionFactory.close(connection);
        }

        return null;
    }

    public T getByName(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        String query = createSelectQuery(type.getDeclaredFields()[1].getName());

        try {
            connection = DatabaseConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            List<T> list = createObjects(resultSet);
            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        } catch (SQLException sqlException) {
            LOGGER.log(Level.WARNING, type.getName() + sqlException.getMessage());
        } finally {
            DatabaseConnectionFactory.close(resultSet);
            DatabaseConnectionFactory.close(statement);
            DatabaseConnectionFactory.close(connection);
        }

        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();

        try {
            while (resultSet.next()) {
                T instance = type.newInstance();

                for (Field field : type.getDeclaredFields()) {
                    Object value = resultSet.getObject(field.getName());
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }

                list.add(instance);

                if (list.size() == 0) {
                    throw new Exception("Size 0");
                }
            }
        } catch (InstantiationException instantiationException) {
            LOGGER.log(Level.WARNING, type.getName(), instantiationException.getMessage());
        } catch (IllegalAccessException illegalAccessException) {
            LOGGER.log(Level.WARNING, type.getName(), illegalAccessException.getMessage());
        } catch (IllegalArgumentException illegalArgumentException) {
            LOGGER.log(Level.WARNING, type.getName(), illegalArgumentException.getMessage());
        } catch (InvocationTargetException invocationTargetException) {
            LOGGER.log(Level.WARNING, type.getName(), invocationTargetException.getMessage());
        } catch (SecurityException securityException) {
            LOGGER.log(Level.WARNING, type.getName(), securityException.getMessage());
        } catch (SQLException sqlException) {
            LOGGER.log(Level.WARNING, type.getName(), sqlException.getMessage());
        } catch (IntrospectionException introspectionException) {
            LOGGER.log(Level.WARNING, type.getName(), introspectionException.getMessage());
        } catch (Exception exception) {
            if (exception.getMessage().compareTo("Size 0") == 0) {
                System.out.println("error - size 0");
            }
        }

        return list;
    }

    private String createInsertQuery(T t) {
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName() + " (");

        boolean first = true;
        boolean second = true;

        for (Field field : type.getDeclaredFields()) {
            if (first) {
                first = false;
            } else if (second) {
                sb.append(field.getName());
                second = false;
            } else {
                sb.append(", " + field.getName());
            }
        }
        sb.append(") VALUES (");

        try {
            first = true;
            second = true;

            for (Field field : type.getDeclaredFields()) {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                Method method = propertyDescriptor.getReadMethod();
                Object value = method.invoke(t);

                if (first) {
                    first = false;
                } else if (second) {
                    sb.append("'" + value.toString() + "'");
                    second = false;
                } else {
                    sb.append(", '" + value.toString() + "'");
                }
            }

        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        } catch (IntrospectionException introspectionException) {
            introspectionException.printStackTrace();
        } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        }

        sb.append(")");

        return sb.toString();
    }

    public int add(T t) {
        Connection connection = null;
        PreparedStatement statement = null;

        String query = createInsertQuery(t);

        try {
            connection = DatabaseConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }

        } catch (SQLException sqlException) {
            LOGGER.log(Level.WARNING, type.getName() + sqlException.getMessage());
        } finally {
            DatabaseConnectionFactory.close(statement);
            DatabaseConnectionFactory.close(connection);
        }

        return -1;
    }

    private String createUpdateQuery(T t, int id) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE " + type.getSimpleName() + " SET ");

        try {
            String idc = "";
            boolean first = true;

            for (Field field : type.getDeclaredFields()) {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                Method method = propertyDescriptor.getReadMethod();
                Object value = method.invoke(t);

                if (first) {
                    sb.append(field.getName() + "='" + value.toString() + "'");
                    idc = field.getName() + "='" + id + "'";
                    first = false;
                } else {
                    sb.append(", " + field.getName() + "='" + value.toString() + "'");
                }
            }

            sb.append(" WHERE " + idc);
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        } catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        } catch (IntrospectionException introspectionException) {
            introspectionException.printStackTrace();
        }

        return sb.toString();
    }

    public boolean update(T t, int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        String query = createUpdateQuery(t, id);

        try {
            connection = DatabaseConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            LOGGER.log(Level.WARNING, type.getName() + sqlException.getMessage());
            return false;
        } finally {
            DatabaseConnectionFactory.close(statement);
            DatabaseConnectionFactory.close(connection);
        }

        return true;
    }

    private String createDeleteQuery(int id) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM " + type.getSimpleName() + " WHERE " + type.getDeclaredFields()[0].getName() + "=" + id);
        return sb.toString();
    }

    public boolean delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        String query = createDeleteQuery(id);

        try {
            connection = DatabaseConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            LOGGER.log(Level.WARNING, type.getName() + sqlException.getMessage());
            return false;
        } finally {
            DatabaseConnectionFactory.close(statement);
            DatabaseConnectionFactory.close(connection);
        }

        return true;
    }
}

