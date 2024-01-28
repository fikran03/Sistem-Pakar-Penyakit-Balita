package com.azhar.spks.model;

import java.io.Serializable;

public class ModelKonsultasi implements Serializable {

    String strGejala = null;
    String kodeGejala = null;
    boolean selected = false;

    public String getKodeGejala() {
        return kodeGejala;
    }

    public void setKodeGejala(String kodeGejala) {
        this.kodeGejala = kodeGejala;
    }
    public String getStrGejala() {
        return strGejala;
    }

    public void setStrGejala(String strGejala) {
        this.strGejala = strGejala;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setEnabled(boolean b) {
    }

    public boolean isEnabled() {
        return true;
    }
}
