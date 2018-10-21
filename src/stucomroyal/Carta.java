/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stucomroyal;

import Several.Utilities;

/**
 *
 * @author USUARIO
 */
public class Carta {
    private String name;
    private int attackLevel;
    private int fenderLevel;
    private int elixirCost;
    private int scoreLevel;
    private TipoCarta cardType;
    private String owner;
    
    
    public Carta(String name, String owner){
        this.name = name;
        this.owner = owner;
    }
    
    public Carta(String name, int attackLevel, int fenderLevel, int elixircost, int scoreLevel, TipoCarta cardType){
        this.name = name;
        this.attackLevel = attackLevel;
        this.fenderLevel = fenderLevel;
        this.elixirCost = elixircost;
        this.scoreLevel = scoreLevel;
        this.cardType = cardType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getFenderLevel() {
        return fenderLevel;
    }

    public void setFenderLevel(int fenderLevel) {
        this.fenderLevel = fenderLevel;
    }

    public int getElixirCost() {
        return elixirCost;
    }

    public void setElixirCost(int elixirCost) {
        
        if(Utilities.elixirStatus(elixirCost)){
            this.elixirCost = elixirCost;
        }
        
    }

    public int getScoreLevel() {
        return scoreLevel;
    }

    public void setScoreLevel(int scoreLevel) {
        if(Utilities.scoreStatus(scoreLevel)){
            this.scoreLevel = scoreLevel;
        }
    }

    public TipoCarta getCardType() {
        return cardType;
    }

    public void setCardType(TipoCarta cardType) {
        this.cardType = cardType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    
    

    
    

}
