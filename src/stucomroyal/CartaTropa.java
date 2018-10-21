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
public class CartaTropa extends Carta{

    private int powerLevel;

    public CartaTropa(String name, int attackLevel, int fenderLevel, int elixircost, int scoreLevel, TipoCarta cardType) {
        super(name, attackLevel, fenderLevel, elixircost, scoreLevel, cardType);
    }
    
    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        if(Utilities.powerStatus(powerLevel)){
            this.powerLevel = powerLevel;
        }
    }

    @Override
    public int getAttackLevel() {
        return super.getAttackLevel() * this.powerLevel;
    }
}
