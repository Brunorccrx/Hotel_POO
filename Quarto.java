/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadehotel;

public class Quarto {
    private int ID;
    private int numQuartos;
    private String situacaoQuarto;
    private String disponibilidadeQuarto;
    public int contador= 0;

    public Quarto(int numQuartos) {
        this.numQuartos = numQuartos;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public int getNumQuartos() {
        return numQuartos;
    }

    public void setNumQuartos(int numQuartos) {
        this.numQuartos = numQuartos;
    }

    public String getSituacaoQuarto() {
        return situacaoQuarto;
    }

    public void setSituacaoQuarto(String situacaoQuarto) {
        this.situacaoQuarto = situacaoQuarto;
    }

    public String getDisponibilidadeQuarto() {
        return disponibilidadeQuarto;
    }

    public void setDisponibilidadeQuarto(String disponibilidadeQuarto) {
        this.disponibilidadeQuarto = disponibilidadeQuarto;
    }
    public void defQuarto(int id, String situacao, String disp){
        this.setID(id);
        this.setSituacaoQuarto(situacao);
        this.setDisponibilidadeQuarto(disp);
    }
    
}
