package org.example;

import java.io.Serializable;

public class Character implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int force;
    private int sante;

    public Character(String name, int force, int sante) {
        this.name = name;
        this.force = force;
        this.sante = sante;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getSante() {
        return sante;
    }

    public void setSante(int sante) {
        this.sante = sante;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", force=" + force +
                ", sante=" + sante +
                '}';
    }
}
