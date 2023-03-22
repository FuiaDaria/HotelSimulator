package org.hotelsimulator.models;

public class Town {
    private int town_id;

    private String town_name;

    public int getTown_id() {
        return town_id;
    }

    public void setTown_id(int town_id) {
        this.town_id = town_id;
    }

    public String getTown_name() {
        return town_name;
    }

    public void setTown_name(String town_name) {
        this.town_name = town_name;
    }

    @Override
    public String toString() {
        return "Town{" +
                "id=" + town_id +
                ", name='" + town_name + '\'' +
                '}';
    }
}
