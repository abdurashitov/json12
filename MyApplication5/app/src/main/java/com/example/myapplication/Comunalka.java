package com.example.myapplication;

public class Comunalka {

        private int id, gas, water, electricity;

    public Comunalka(int id, int gas, int water, int electricity) {
        this.id = id;
        this.gas = gas;
        this.water = water;
        this.electricity = electricity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getElectricity() {
        return electricity;
    }

    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }

    @Override
        public  String toString() {
        return id + " " + gas + " " + water + " " + electricity;
    }
}
