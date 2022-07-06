/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Matias
 */
public class ActividadExponencial implements IActividad{
    private double media;
    private double lambda;

    public ActividadExponencial(double media) {
        this.media = media;
        this.lambda= 1/media;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda(double lambda) {
        this.lambda = lambda;
    }

    /**
     * Devuelve una variable aleatoria generada en base a la media que se seteo en el constructor. Calcula en base a la formula (-1/λ)*ln(1-RND)
     * @param random
     * @return 
     */
    @Override
    public double calcularTiempo(double random) {
        double x = -media*Math.log(1-random);
        
        x = (double) Math.round(x * 10000d) / 10000d;
        return x;
    }
    
    
}
