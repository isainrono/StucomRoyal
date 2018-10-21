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
public class CartaEstructura extends Carta{
    private int coatLevel;

    public CartaEstructura(String name, int attackLevel, int fenderLevel, int elixircost, int scoreLevel, TipoCarta cardType) {
        super(name, attackLevel, fenderLevel, elixircost, scoreLevel, cardType);
    }

    public int getCoatLevel() {
        return coatLevel;
    }

    public void setCoatLevel(int coatLevel) {
        if(Utilities.coatStatus(coatLevel)){
            this.coatLevel = coatLevel;
        }
        
    }

    @Override
    public int getFenderLevel() {
        return super.getFenderLevel() + this.coatLevel;
    }

    
}
