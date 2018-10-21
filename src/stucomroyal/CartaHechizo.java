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
public class CartaHechizo extends Carta {

    private int reach;

    public CartaHechizo(String name, int attackLevel, int fenderLevel, int elixircost, int scoreLevel, TipoCarta cardType) {
        super(name, attackLevel, fenderLevel, elixircost, scoreLevel, cardType);
    }

    public int getReach() {
        return reach;
    }

    public void setReach(int reach) {
        if(Utilities.reachStatus(reach)){
            this.reach = reach;
        }
    }

    @Override
    public int getAttackLevel() {
        return super.getAttackLevel() + this.reach;
    }
    
    @Override
    public int getFenderLevel() {
        return super.getFenderLevel() + this.reach;
    }

}
