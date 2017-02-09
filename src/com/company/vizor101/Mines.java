package com.company.vizor101;

/**
 * Created by Administrator on 09.02.17.
 */
public class Mines {
    public int num;
    public String mineType;
    public String mineName;
    public int mineLevel;

    public Mines(int _num, String _mineType, String _mineName, int _mineLevel) {
        num = _num;
        mineType = _mineType;
        mineName = _mineName;
        mineLevel = _mineLevel;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setMineLevel(int mineLevel) {
        this.mineLevel = mineLevel;
    }

    public int getMineLevel() {
        return mineLevel;
    }

    public void setMineName(String mineName) {
        this.mineName = mineName;
    }

    public String getMineName() {
        return mineName;
    }

    public void setMineType(String mineType) {
        this.mineType = "Дерево";
    }

    public String getMineType() {
        return mineType;
    }
}