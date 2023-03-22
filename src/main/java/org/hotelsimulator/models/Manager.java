package org.hotelsimulator.models;

public class Manager {
    private int manager_id;
    private String manager_name;
    private int manager_hotel;

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public int getManager_hotel() {
        return manager_hotel;
    }

    public void setManager_hotel(int manager_hotel) {
        this.manager_hotel = manager_hotel;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manager_id=" + manager_id +
                ", manager_name='" + manager_name + '\'' +
                ", manager_hotel=" + manager_hotel +
                '}';
    }
}
