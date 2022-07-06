/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.math3.distribution.TDistribution;

/**
 *
 * @author Usuario
 */
public class Fila2 {

    double reloj = 0;
    Evento e;
    int contadorN;
    int tarea;
    int proximaTarea;
    double rndTarea;
    double tiempoEntreLlegadas;
    double proxLlegada;
    Estado estadoT1;
    double rndTrabajador1;
    double TiempoDeAtencionTrabajador1;
    double proxFinAtencionTrabajador1;
    int colaE1;
    Estado estadoT2;
    double rndTrabajador2;
    double TiempoDeAtencionTrabajador2;
    double proxFinAtencionTrabajador2;
    Estado estadoT3;
    double rndTrabajador3;
    double TiempoDeAtencionTrabajador3;
    double proxFinAtencionTrabajador3;
    int colaE2;
    Estado estadoT4;
    double rndTrabajador4;
    double TiempoDeAtencionTrabajador4;
    double proxFinAtencionTrabajador4;
    Estado estadoT5;
    double rndTrabajador5;
    double TiempoDeAtencionTrabajador5;
    double proxFinAtencionTrabajador5;
    Estado estadoT6;
    double rndTrabajador6;
    double TiempoDeAtencionTrabajador6;
    double proxFinAtencionTrabajador6;
    int colaE3;
    double rndFinInspE1;
    boolean vuelveAEtapa1;
    double rndFinInspE2;
    boolean vuelveAEtapa2;
    int tareasTerminadas;
    double tiempoOcupacionT1;
    double tiempoOcupacionT2;
    double tiempoOcupacionT3;
    double tiempoOcupacionT4;
    double tiempoOcupacionT5;
    double tiempoOcupacionT6;

    IActividad calcActividadEnsamble;
    IActividad paraLlegada;
    IActividad paraE1;
    IActividad paraE2;
    IActividad paraE3;

    double auxTiempoVuelta;
    Tarea[] vecTareas;
    int contLlegadas;
    int limiteVector;
    int control;

    public Fila2() {
    }

    //IEDSolver solver;
    public Fila2(Evento e, int tarea, int proximaTarea, double rndTarea, double tiempoEntreLlegadas, double proxLlegada, Estado T1, double rndTrabajador1, double rndTiempoDeAtencionTrabajador1, double proxFinAtencionTrabajador1, int colaE1, Estado T2, double rndTrabajador2, double rndTiempoDeAtencionTrabajador2, double proxFinAtencionTrabajador2, Estado T3, double rndTrabajador3, double rndTiempoDeAtencionTrabajador3, double proxFinAtencionTrabajador3, int colaE2, Estado T4, double rndTrabajador4, double rndTiempoDeAtencionTrabajador4, double proxFinAtencionTrabajador4, Estado T5, double rndTrabajador5, double rndTiempoDeAtencionTrabajador5, double proxFinAtencionTrabajador5, Estado T6, double rndTrabajador6, double rndTiempoDeAtencionTrabajador6, double proxFinAtencionTrabajador6, int colaE3, double rndFinInspE1, boolean vuelveAEtapa1, double rndFinInspE2, boolean vuelveAEtapa2, int tareasTerminadas, double tiempoOcupacionT1, double tiempoOcupacionT2, double tiempoOcupacionT3, double tiempoOcupacionT4, double tiempoOcupacionT5, double tiempoOcupacionT6, IActividad calcActividadEnsamble, int contadorN) {
        this.e = e;
        this.tarea = tarea;
        this.proximaTarea = proximaTarea;
        this.rndTarea = rndTarea;
        this.tiempoEntreLlegadas = tiempoEntreLlegadas;
        this.proxLlegada = proxLlegada;
        this.estadoT1 = T1;
        this.rndTrabajador1 = rndTrabajador1;
        this.TiempoDeAtencionTrabajador1 = rndTiempoDeAtencionTrabajador1;
        this.proxFinAtencionTrabajador1 = proxFinAtencionTrabajador1;
        this.colaE1 = colaE1;
        this.estadoT2 = T2;
        this.rndTrabajador2 = rndTrabajador2;
        this.TiempoDeAtencionTrabajador2 = rndTiempoDeAtencionTrabajador2;
        this.proxFinAtencionTrabajador2 = proxFinAtencionTrabajador2;
        this.estadoT3 = T3;
        this.rndTrabajador3 = rndTrabajador3;
        this.TiempoDeAtencionTrabajador3 = rndTiempoDeAtencionTrabajador3;
        this.proxFinAtencionTrabajador3 = proxFinAtencionTrabajador3;
        this.colaE2 = colaE2;
        this.estadoT4 = T4;
        this.rndTrabajador4 = rndTrabajador4;
        this.TiempoDeAtencionTrabajador4 = rndTiempoDeAtencionTrabajador4;
        this.proxFinAtencionTrabajador4 = proxFinAtencionTrabajador4;
        this.estadoT5 = T5;
        this.rndTrabajador5 = rndTrabajador5;
        this.TiempoDeAtencionTrabajador5 = rndTiempoDeAtencionTrabajador5;
        this.proxFinAtencionTrabajador5 = proxFinAtencionTrabajador5;
        this.estadoT6 = T6;
        this.rndTrabajador6 = rndTrabajador6;
        this.TiempoDeAtencionTrabajador6 = rndTiempoDeAtencionTrabajador6;
        this.proxFinAtencionTrabajador6 = proxFinAtencionTrabajador6;
        this.colaE3 = colaE3;
        this.rndFinInspE1 = rndFinInspE1;
        this.vuelveAEtapa1 = vuelveAEtapa1;
        this.rndFinInspE2 = rndFinInspE2;
        this.vuelveAEtapa2 = vuelveAEtapa2;
        this.tareasTerminadas = tareasTerminadas;
        this.tiempoOcupacionT1 = tiempoOcupacionT1;
        this.tiempoOcupacionT2 = tiempoOcupacionT2;
        this.tiempoOcupacionT3 = tiempoOcupacionT3;
        this.tiempoOcupacionT4 = tiempoOcupacionT4;
        this.tiempoOcupacionT5 = tiempoOcupacionT5;
        this.tiempoOcupacionT6 = tiempoOcupacionT6;
        this.calcActividadEnsamble = calcActividadEnsamble;
        this.contadorN = contadorN;

    }

    /**
     * Inicializa las instancias de ActividadExponencial para cada etapa,
     * enviando como parametro 1/lambda (Osea la media)
     *
     * @param lambdaLlegada
     * @param lambdaE1
     * @param lambdaE2
     * @param lambdaInsp
     */
    public Fila2(double lambdaLlegada, double lambdaE1, double lambdaE2, double lambdaInsp) {
        this.paraLlegada = new ActividadExponencial(1 / lambdaLlegada);
        this.paraE1 = new ActividadExponencial(1 / lambdaE1);
        this.paraE2 = new ActividadExponencial(1 / lambdaE2);
        this.paraE3 = new ActividadExponencial(1 / lambdaInsp);
    }

    /**
     * Calculo de la primera fila, seteando el estado inicial de todas las
     * columnas. Recibe el parametro tamVec para definir el tamaño del vector de
     * tareas que va a utilizar
     *
     * @param tamVec
     */
    public void CalcularPrimeraFila(int tamVec) {
        e = e.Inicio;
        tarea = 0;
        proximaTarea = 1;
        auxTiempoVuelta = 999999.0;

        generarNuevaLlegadaInicial();

        proxFinAtencionTrabajador1 = 999999.0;
        proxFinAtencionTrabajador2 = 999999.0;
        proxFinAtencionTrabajador3 = 999999.0;
        proxFinAtencionTrabajador4 = 999999.0;
        proxFinAtencionTrabajador5 = 999999.0;
        proxFinAtencionTrabajador6 = 999999.0;
        rndFinInspE1 = 999999.0;
        rndFinInspE2 = 999999.0;
        vuelveAEtapa1 = false;
        vuelveAEtapa2 = false;

        estadoT1 = Estado.Libre;
        estadoT2 = Estado.Libre;
        estadoT3 = Estado.Libre;
        estadoT4 = Estado.Libre;
        estadoT5 = Estado.Libre;
        estadoT6 = Estado.Libre;
        colaE1 = 0;
        colaE2 = 0;
        colaE3 = 0;
        tareasTerminadas = 0;
        contadorN = 1;
        limiteVector = tamVec;
        control = tamVec;
        vecTareas = new Tarea[tamVec];
        for (int i = 0; i < vecTareas.length; i++) {
            vecTareas[i] = new Tarea();
        }
    }

    public void CalcularNuevaFila() {
        double tempreloj = this.reloj;
        this.reloj = menorTiempo();
        Estado estadoAnteriorT1 = estadoT1;
        Estado estadoAnteriorT2 = estadoT2;
        Estado estadoAnteriorT3 = estadoT3;
        Estado estadoAnteriorT4 = estadoT4;
        Estado estadoAnteriorT5 = estadoT5;
        Estado estadoAnteriorT6 = estadoT6;
        calcularEventoSiguiente();

        double controlRndLlegada = rndTarea;
        double controlTEntreLl = tiempoEntreLlegadas;
        double controlRndT1 = rndTrabajador1;
        double controlTAtT1 = TiempoDeAtencionTrabajador1;
        double controlRndT6 = rndTrabajador6;
        double controlTAtT6 = TiempoDeAtencionTrabajador6;
        double controlRndT5 = rndTrabajador5;
        double controlTAtT5 = TiempoDeAtencionTrabajador5;
        double controlRndT4 = rndTrabajador4;
        double controlTAtT4 = TiempoDeAtencionTrabajador4;
        double controlRndT2 = rndTrabajador2;
        double controlTAtT2 = TiempoDeAtencionTrabajador2;
        double controlRndT3 = rndTrabajador3;
        double controlTAtT3 = TiempoDeAtencionTrabajador3;

        //Evento de llegada de tarea
        if (e == Evento.LlegaTarea) {
            //Genero una nueva llegada
            rndTarea = Math.random();
            tiempoEntreLlegadas = paraLlegada.calcularTiempo(rndTarea);
            proxLlegada += tiempoEntreLlegadas;

            Estado prevEstadoT1 = estadoT1;
            int prevColaE1 = colaE1;

            //Si el Trabajador 1 estaba ocupado en la iteracion anterior, la tarea pasa a cola
            if (prevEstadoT1 == Estado.Ocupado) {
                colaE1 = prevColaE1 + 1;

                // Si el contador de llegadas todavia no esta igual al limite vector (Que tiene como valor el tamaño del vector de tareas),
                // modificar su estado a EnColaE1, con su posicion y hora de llegada.
                //Por ultimo se incrementa el contador de llegadas
                if (contLlegadas < limiteVector) {
                    vecTareas[contLlegadas].setEstado(EstadoTareas.EnColaE1);
                    vecTareas[contLlegadas].setPosicion(colaE1);
                    vecTareas[contLlegadas].setHoraLlegada(reloj);
                    contLlegadas++;
                }
            }

            //Si estaba libre el trabajador 1, pasarlo a ocupado
            if (prevEstadoT1 == Estado.Libre) {
                estadoT1 = Estado.Ocupado;
            }

            //Si antes estaba libre y paso a ocupado, generar un random para procesar la tarea.
            if (prevEstadoT1 == Estado.Libre && estadoT1 == Estado.Ocupado) {
                rndTrabajador1 = Math.random();
            } else {
                rndTrabajador1 = 999999.0;
            }

            //Si se genero el random, calcular el tiempo de el trabajador 1 en base a la ActividadExponencial, y se la asigna al proximo fin de atencion del T1
            if (rndTrabajador1 != 999999.0) {
                TiempoDeAtencionTrabajador1 = paraE1.calcularTiempo(rndTrabajador1);
                proxFinAtencionTrabajador1 = reloj + TiempoDeAtencionTrabajador1;

                // Si el contador de llegadas todavia no esta igual al limite vector (Que tiene como valor el tamaño del vector de tareas),
                // modificar su estado a ProcesandoE1, con su posicion y hora de llegada. Ademas, se asigna la hora de fin de atencion para esa tarea.
                //Por ultimo se incrementa el contador de llegadas
                if (contLlegadas < limiteVector) {
                    vecTareas[contLlegadas].setEstado(EstadoTareas.ProcesandoE1);
                    vecTareas[contLlegadas].setPosicion(0);
                    vecTareas[contLlegadas].setHoraLlegada(reloj);
                    vecTareas[contLlegadas].setHoraFinEventoActual(proxFinAtencionTrabajador1);
                    contLlegadas++;
                }

            }
            rndFinInspE1 = 999999.0;
            rndFinInspE2 = 999999.0;
            vuelveAEtapa1 = false;
            vuelveAEtapa2 = false;
        }

        //Evento de vuelta de tarea a Etapa 1 luego de inspeccion
        if (e == Evento.VueltaEtapa1) {
            Estado prevEstadoT1 = estadoT1;
            int prevColaE1 = colaE1;
            // Si el trabajador 1 venia ocupado de la iteracion anterior, sumar la tarea a la cola.
            if (prevEstadoT1 == Estado.Ocupado) {
                colaE1 = prevColaE1 + 1;

                //Si el contador de control es mayor a 0 (Se disminuye cada vez que finaliza una tarea para no pasarse de la cantidad en el vector de tareas) 
                //Recorro el vector de tareas y me fijo cual de ellas es la que vuelve de una inspeccion. Luego la coloco en cola.
                if (control > 0) {
                    for (Tarea vecTarea : vecTareas) {
                        if (vecTarea.getEstado() == EstadoTareas.VuelveE1 && vecTarea.getHoraFinEventoActual() == reloj) {
                            vecTarea.setEstado(EstadoTareas.EnColaE1);
                            vecTarea.setPosicion(colaE1);
                        }

                    }
                }
            }

            if (prevEstadoT1 == Estado.Libre) {
                estadoT1 = Estado.Ocupado;
            }

            //Si antes estaba libre y paso a ocupado, generar un random para procesar la tarea. Si no, lo vuelvo a 999999.0.
            if (prevEstadoT1 == Estado.Libre && estadoT1 == Estado.Ocupado) {
                rndTrabajador1 = Math.random();
            } else {
                rndTrabajador1 = 999999.0;
            }
            // Si se genero el random, genero nuevo tiempo de atencion
            if (rndTrabajador1 != 999999.0) {
                TiempoDeAtencionTrabajador1 = paraE1.calcularTiempo(rndTrabajador1);
                proxFinAtencionTrabajador1 = reloj + TiempoDeAtencionTrabajador1;

                //Si el contador de control es mayor a 0 (Se disminuye cada vez que finaliza una tarea para no pasarse de la cantidad en el vector de tareas) 
                //Recorro el vector de tareas y me fijo cual de ellas es la que vuelve de una inspeccion, y actualizo su estado y tiempo de atencion.
                if (control > 0) {
                    for (Tarea vecTarea : vecTareas) {
                        if (vecTarea.getEstado() == EstadoTareas.VuelveE1 && vecTarea.getHoraFinEventoActual() == reloj) {
                            vecTarea.setEstado(EstadoTareas.ProcesandoE1);
                            vecTarea.setPosicion(0);
                            vecTarea.setHoraFinEventoActual(proxFinAtencionTrabajador1);
                        }
                    }
                }
            }

            rndFinInspE1 = 999999.0;
            rndFinInspE2 = 999999.0;
            vuelveAEtapa1 = false;
            vuelveAEtapa2 = false;
            auxTiempoVuelta = 999999.0;
        }

        // Evento de fin de etapa 1
        if (e == Evento.FinE1) {

            int prevColaE1 = colaE1;

            //Si habia algo en la cola de etapa 1, la disminuyo. Si no habia nada, libero al trabajador
            if (prevColaE1 != 0) {
                colaE1 -= 1;
            } else {
                estadoT1 = Estado.Libre;
                rndTrabajador1 = 999999.0;
                TiempoDeAtencionTrabajador1 = 999999.0;
                proxFinAtencionTrabajador1 = 999999.0;
            }

            //Si cambio la cola con respecto a la iteracion anterior, genero random y calculo nuevo tiempo de atencion
            if (prevColaE1 > colaE1) {
                rndTrabajador1 = Math.random();
                TiempoDeAtencionTrabajador1 = paraE1.calcularTiempo(rndTrabajador1);
                proxFinAtencionTrabajador1 = reloj + TiempoDeAtencionTrabajador1;

                //Si habia alguna tarea en cola en posicion 1, quiere decir que es la que esta siendo atendida. Le actualizo sus datos. Al resto de las tareas
                //En cola, le disminuyo su posicion en 1.
                if (control > 0) {
                    for (Tarea vecTarea : vecTareas) {
                        if (vecTarea.getPosicion() == 1 && vecTarea.getEstado() == EstadoTareas.EnColaE1) {
                            vecTarea.setEstado(EstadoTareas.ProcesandoE1);
                            vecTarea.setPosicion(0);
                            vecTarea.setHoraFinEventoActual(proxFinAtencionTrabajador1);
                        } else if (vecTarea.getEstado() == EstadoTareas.EnColaE1) {
                            int s = vecTarea.getPosicion();
                            vecTarea.setPosicion(s - 1);
                        }
                    }

                }
            }

            ///////////// Paso de la tarea a etapa 2 /////////////
            //Si el trabajador 2 esta libre, se la asigno a el.
            if (estadoT2 == Estado.Libre) {
                estadoT2 = Estado.Ocupado;
                rndTrabajador2 = Math.random();
                TiempoDeAtencionTrabajador2 = paraE2.calcularTiempo(rndTrabajador2);
                proxFinAtencionTrabajador2 = reloj + TiempoDeAtencionTrabajador2;

                //Si habia alguna tarea que estaba siendo procesada en la etapa 1, y el tiempo actual del reloj es el mismo que esa tarea, quiere decir que es la que finalizo.
                // Le asigno el estado a siendo procesada en etapa 2 (Trabajador 2) con un nuevo tiempo de fin de atencion.
                if (control > 0) {
                    for (Tarea vecTarea : vecTareas) {
                        if (vecTarea.getHoraFinEventoActual() == reloj && vecTarea.getEstado() == EstadoTareas.ProcesandoE1) {
                            vecTarea.setEstado(EstadoTareas.ProcesandoE2T2);
                            vecTarea.setPosicion(0);
                            vecTarea.setHoraFinEventoActual(proxFinAtencionTrabajador2);
                        }
                    }

                }

            } //Si el trabajador 3 esta libre, se la asigno a el.
            else if (estadoT3 == Estado.Libre) {
                estadoT3 = Estado.Ocupado;
                rndTrabajador3 = Math.random();
                TiempoDeAtencionTrabajador3 = paraE2.calcularTiempo(rndTrabajador3);
                proxFinAtencionTrabajador3 = reloj + TiempoDeAtencionTrabajador3;

                //Si habia alguna tarea que estaba siendo procesada en la etapa 1, y el tiempo actual del reloj es el mismo que esa tarea, quiere decir que es la que finalizo.
                // Le asigno el estado a siendo procesada en etapa 2 (Trabajador 3) con un nuevo tiempo de fin de atencion.
                if (control > 0) {
                    for (Tarea vecTarea : vecTareas) {
                        if (vecTarea.getHoraFinEventoActual() == reloj && vecTarea.getEstado() == EstadoTareas.ProcesandoE1) {
                            vecTarea.setEstado(EstadoTareas.ProcesandoE2T3);
                            vecTarea.setPosicion(0);
                            vecTarea.setHoraFinEventoActual(proxFinAtencionTrabajador3);
                        }
                    }
                }
            } // Si ninguno esta libre, agrego la tarea a la cola de la etapa 2.
            else {
                colaE2++;

                // Si habia alguna tarea que estaba siendo procesada en la etapa 1, y el tiempo actual del reloj es el mismo que esa tarea, quiere decir que es la que finalizo.
                // Como no hay trabajador libre, le actualizo su estado a cola E2 y actualizo su posicion en esa cola.
                if (control > 0) {
                    for (Tarea vecTarea : vecTareas) {
                        if (vecTarea.getHoraFinEventoActual() == reloj && vecTarea.getEstado() == EstadoTareas.ProcesandoE1) {
                            vecTarea.setEstado(EstadoTareas.EnColaE2);
                            vecTarea.setPosicion(colaE2);
                            vecTarea.setHoraFinEventoActual(999999.0);
                        }
                    }

                }
            }
            rndFinInspE1 = 999999.0;
            rndFinInspE2 = 999999.0;
            vuelveAEtapa1 = false;
            vuelveAEtapa2 = false;
        }

        //Evento de vuelta a etapa 2
        if (e == Evento.VueltaEtapa2) {

            //Si el trabajador 2 esta libre, toma la tarea
            if (estadoT2 == Estado.Libre) {
                estadoT2 = Estado.Ocupado;
                rndTrabajador2 = Math.random();
                TiempoDeAtencionTrabajador2 = paraE2.calcularTiempo(rndTrabajador2);
                proxFinAtencionTrabajador2 = reloj + TiempoDeAtencionTrabajador2;

                // Si habia alguna tarea que volvio a la etapa 2, y el tiempo actual del reloj es el mismo que esa tarea, quiere decir que es la que necesito actualizar.
                // Le seteo los parametros con el estado de siendo procesado por el trabajador 2
                if (control > 0) {
                    for (Tarea vecTarea : vecTareas) {
                        if (vecTarea.getEstado() == EstadoTareas.VuelveE2 && vecTarea.getHoraFinEventoActual() == reloj) {
                            vecTarea.setEstado(EstadoTareas.ProcesandoE2T2);
                            vecTarea.setPosicion(0);
                            vecTarea.setHoraFinEventoActual(proxFinAtencionTrabajador2);
                        }
                    }
                }

            } //Idem anterior, pero si el trabajador 2 esta ocupado y el 3 esta libre
            else if (estadoT3 == Estado.Libre) {
                estadoT3 = Estado.Ocupado;
                rndTrabajador3 = Math.random();
                TiempoDeAtencionTrabajador3 = paraE2.calcularTiempo(rndTrabajador3);
                proxFinAtencionTrabajador3 = reloj + TiempoDeAtencionTrabajador3;
                if (control > 0) {
                    for (Tarea vecTarea : vecTareas) {
                        if (vecTarea.getEstado() == EstadoTareas.VuelveE2 && vecTarea.getHoraFinEventoActual() == reloj) {
                            vecTarea.setEstado(EstadoTareas.ProcesandoE2T3);
                            vecTarea.setPosicion(0);
                            vecTarea.setHoraFinEventoActual(proxFinAtencionTrabajador3);
                        }
                    }
                }
            } //Si ninguno de los dos esta libre, lo sumo a la cola, y actualizo la tarea que volvio a e2 a la cola de e2 con su correspondiente posicion. 
            else {
                colaE2++;
                if (control > 0) {
                    for (Tarea vecTarea : vecTareas) {
                        if (vecTarea.getEstado() == EstadoTareas.VuelveE2 && vecTarea.getHoraFinEventoActual() == reloj) {
                            vecTarea.setEstado(EstadoTareas.EnColaE2);
                            vecTarea.setPosicion(colaE2);
                        }

                    }
                }
            }
            rndFinInspE1 = 999999.0;
            rndFinInspE2 = 999999.0;
            vuelveAEtapa1 = false;
            vuelveAEtapa2 = false;
            auxTiempoVuelta = 999999.0;
        }

        //Evento de fin de etapa 2 (Trabajador 2 y 3)
        
        if (e == Evento.FinE2) {
            int prevColaE2 = colaE2;
            
            //Si el fin de etapa 2 corresponde al trabajador 2, opero sobre este
            if (reloj == proxFinAtencionTrabajador2) {
                
                //Si habia algo en cola, la disminuyo y genero un nuevo procesamiento de tarea.
                if (prevColaE2 != 0) {
                    colaE2--;
                    rndTrabajador2 = Math.random();
                    TiempoDeAtencionTrabajador2 = paraE2.calcularTiempo(rndTrabajador2);
                    proxFinAtencionTrabajador2 = reloj + TiempoDeAtencionTrabajador2;

                    //Si habia alguna tarea del vector en la posicion 1 de la cola E2, es la que va a procesar el trabajador 2.
                    if (control > 0) {
                        for (Tarea vecTarea : vecTareas) {
                            if (vecTarea.getPosicion() == 1 && vecTarea.getEstado() == EstadoTareas.EnColaE2) {
                                vecTarea.setEstado(EstadoTareas.ProcesandoE2T2);
                                vecTarea.setPosicion(0);
                                vecTarea.setHoraFinEventoActual(proxFinAtencionTrabajador2);
                            }// Al resto de las tareas en cola E2 les disminuyo  su posicion en 1
                            else if (vecTarea.getEstado() == EstadoTareas.EnColaE2) {
                                int s = vecTarea.getPosicion();
                                vecTarea.setPosicion(s - 1);
                            }
                        }

                    }
                } //Si no habia nada en cola, libero al trabajador. 
                else {
                    estadoT2 = Estado.Libre;
                    rndTrabajador2 = 999999.0;
                    TiempoDeAtencionTrabajador2 = 999999.0;
                    proxFinAtencionTrabajador2 = 999999.0;
                }
            } //Si el fin de etapa 2 corresponde al trabajador 3, opero sobre este 
            else if (reloj == proxFinAtencionTrabajador3) {
                
                //Si habia algo en cola, la disminuyo y genero un nuevo procesamiento de tarea.
                if (prevColaE2 != 0) {
                    colaE2--;
                    rndTrabajador3 = Math.random();
                    TiempoDeAtencionTrabajador3 = paraE2.calcularTiempo(rndTrabajador3);
                    proxFinAtencionTrabajador3 = reloj + TiempoDeAtencionTrabajador3;
                    
                    //Si habia alguna tarea del vector en la posicion 1 de la cola E2, es la que va a procesar el trabajador 3.
                    if (control > 0) {
                        for (Tarea vecTarea : vecTareas) {
                            if (vecTarea.getPosicion() == 1 && vecTarea.getEstado() == EstadoTareas.EnColaE2) {
                                vecTarea.setEstado(EstadoTareas.ProcesandoE2T3);
                                vecTarea.setPosicion(0);
                                vecTarea.setHoraFinEventoActual(proxFinAtencionTrabajador3);
                            } // Al resto de las tareas en cola E2 les disminuyo  su posicion en 1 
                            else if (vecTarea.getEstado() == EstadoTareas.EnColaE2) {
                                int s = vecTarea.getPosicion();
                                vecTarea.setPosicion(s - 1);
                            }
                        }

                    }
                } //Si no habia nada en cola, libero al trabajador. 
                else {
                    estadoT3 = Estado.Libre;
                    rndTrabajador3 = 999999.0;
                    TiempoDeAtencionTrabajador3 = 999999.0;
                    proxFinAtencionTrabajador3 = 999999.0;
                }
            }

            ///////////// Paso de la tarea a etapa de inspeccion ////////////
            // Si el trabajador 4 esta libre, toma la tarea.
            if (estadoT4 == Estado.Libre) {
                estadoT4 = Estado.Ocupado;
                rndTrabajador4 = Math.random();
                TiempoDeAtencionTrabajador4 = paraE3.calcularTiempo(rndTrabajador4);
                proxFinAtencionTrabajador4 = reloj + TiempoDeAtencionTrabajador4;

                 //Si habia alguna tarea siendo procesado por el T2 o T3, y coincide con el reloj actual, quiere decir que es la que esta tomando el trabajador  4
                if (control > 0) {
                    for (Tarea vecTarea : vecTareas) {
                        if (vecTarea.getHoraFinEventoActual() == reloj && (vecTarea.getEstado() == EstadoTareas.ProcesandoE2T2 || vecTarea.getEstado() == EstadoTareas.ProcesandoE2T3)) {
                            vecTarea.setEstado(EstadoTareas.ProcesandoE3T4);
                            vecTarea.setPosicion(0);
                            vecTarea.setHoraFinEventoActual(proxFinAtencionTrabajador4);
                        }
                    }

                }

            }// Si el trabajador 5 esta libre, toma la tarea.
            else if (estadoT5 == Estado.Libre) {
                estadoT5 = Estado.Ocupado;
                rndTrabajador5 = Math.random();
                TiempoDeAtencionTrabajador5 = paraE3.calcularTiempo(rndTrabajador5);
                proxFinAtencionTrabajador5 = reloj + TiempoDeAtencionTrabajador5;

                 //Si habia alguna tarea siendo procesado por el T2 o T3, y coincide con el reloj actual, quiere decir que es la que esta tomando el trabajador  5
                if (control > 0) {
                    for (Tarea vecTarea : vecTareas) {
                        if (vecTarea.getHoraFinEventoActual() == reloj && (vecTarea.getEstado() == EstadoTareas.ProcesandoE2T2 || vecTarea.getEstado() == EstadoTareas.ProcesandoE2T3)) {
                            vecTarea.setEstado(EstadoTareas.ProcesandoE3T5);
                            vecTarea.setPosicion(0);
                            vecTarea.setHoraFinEventoActual(proxFinAtencionTrabajador5);
                        }
                    }

                }
            } // Si el trabajador 5 esta libre, toma la tarea.
            else if (estadoT6 == Estado.Libre) {
                estadoT6 = Estado.Ocupado;
                rndTrabajador6 = Math.random();
                TiempoDeAtencionTrabajador6 = paraE3.calcularTiempo(rndTrabajador6);
                proxFinAtencionTrabajador6 = reloj + TiempoDeAtencionTrabajador6;
                
                //Si habia alguna tarea siendo procesado por el T2 o T3, y coincide con el reloj actual, quiere decir que es la que esta tomando el trabajador 6
                if (control > 0) {
                    for (Tarea vecTarea : vecTareas) {
                        if (vecTarea.getHoraFinEventoActual() == reloj && (vecTarea.getEstado() == EstadoTareas.ProcesandoE2T2 || vecTarea.getEstado() == EstadoTareas.ProcesandoE2T3)) {
                            vecTarea.setEstado(EstadoTareas.ProcesandoE3T6);
                            vecTarea.setPosicion(0);
                            vecTarea.setHoraFinEventoActual(proxFinAtencionTrabajador6);
                        }
                    }
                }
            } //Si ninguno esta libre, coloco la tarea en cola. 
            else {
                colaE3++;
                
                 //Si habia alguna tarea siendo procesado por el T2 o T3, y coincide con el reloj actual, se la coloca en cola de la etapa de inspeccion.
                if (control > 0) {
                    for (Tarea vecTarea : vecTareas) {
                        if (vecTarea.getHoraFinEventoActual() == reloj && (vecTarea.getEstado() == EstadoTareas.ProcesandoE2T2 || vecTarea.getEstado() == EstadoTareas.ProcesandoE2T3)) {
                            vecTarea.setEstado(EstadoTareas.EnColaE3);
                            vecTarea.setPosicion(colaE3);
                            vecTarea.setHoraFinEventoActual(999999.0);
                        }
                    }

                }
            }
            rndFinInspE1 = 999999.0;
            rndFinInspE2 = 999999.0;
            vuelveAEtapa1 = false;
            vuelveAEtapa2 = false;
        }

        
        //Evento de fin de inspeccion
        if (e == Evento.FinInspeccion) {
            int prevColaE3 = colaE3;
            
            //Si la inspeccion que termina es del trabajador 4
            if (proxFinAtencionTrabajador4 == reloj) {
                
                //Si habia algo en cola la disminuyo, y genero una nueva atencion
                if (prevColaE3 != 0) {
                    colaE3--;
                    rndTrabajador4 = Math.random();
                    TiempoDeAtencionTrabajador4 = paraE3.calcularTiempo(rndTrabajador4);
                    proxFinAtencionTrabajador4 = reloj + TiempoDeAtencionTrabajador4;

                    //Si alguna de las tareas que estaban en el vector de tareas estaba en cola, y su posicion era 1, quiere decir que es la que esta tomando el trabajador 4
                    if (control > 0) {
                        for (Tarea vecTarea : vecTareas) {
                            if (vecTarea.getPosicion() == 1 && vecTarea.getEstado() == EstadoTareas.EnColaE3) {
                                vecTarea.setEstado(EstadoTareas.ProcesandoE3T4);
                                vecTarea.setPosicion(0);
                                vecTarea.setHoraFinEventoActual(proxFinAtencionTrabajador4);
                            } //Al resto de las tareas en cola E3, le disminuyo en 1 su posicion. 
                            else if (vecTarea.getEstado() == EstadoTareas.EnColaE3) {
                                int s = vecTarea.getPosicion();
                                vecTarea.setPosicion(s - 1);
                            }
                        }

                    }

                } //Si no hay nada en cola, libero al trabajador 4
                else {
                    estadoT4 = Estado.Libre;
                    rndTrabajador4 = 999999.0;
                    TiempoDeAtencionTrabajador4 = 999999.0;
                    proxFinAtencionTrabajador4 = 999999.0;
                }

            } //Si la inspeccion que termina es del trabajador 5
            else if (proxFinAtencionTrabajador5 == reloj) {
                
                //Si habia algo en cola la disminuyo, y genero una nueva atencion
                if (prevColaE3 != 0) {
                    colaE3--;
                    rndTrabajador5 = Math.random();
                    TiempoDeAtencionTrabajador5 = paraE3.calcularTiempo(rndTrabajador5);
                    proxFinAtencionTrabajador5 = reloj + TiempoDeAtencionTrabajador5;

                    //Si alguna de las tareas que estaban en el vector de tareas estaba en cola, y su posicion era 1, quiere decir que es la que esta tomando el trabajador 5
                    if (control > 0) {
                        for (Tarea vecTarea : vecTareas) {
                            if (vecTarea.getPosicion() == 1 && vecTarea.getEstado() == EstadoTareas.EnColaE3) {
                                vecTarea.setEstado(EstadoTareas.ProcesandoE3T5);
                                vecTarea.setPosicion(0);
                                vecTarea.setHoraFinEventoActual(proxFinAtencionTrabajador5);
                            } //Al resto de las tareas en cola E3, le disminuyo en 1 su posicion.  
                            else if (vecTarea.getEstado() == EstadoTareas.EnColaE3) {
                                int s = vecTarea.getPosicion();
                                vecTarea.setPosicion(s - 1);
                            }
                        }

                    }

                } //Si no hay nada en cola, libero al trabajador 5
                else {
                    estadoT5 = Estado.Libre;
                    rndTrabajador5 = 999999.0;
                    TiempoDeAtencionTrabajador5 = 999999.0;
                    proxFinAtencionTrabajador5 = 999999.0;
                }

            } //Si la inspeccion que termina es del trabajador 6
            else if (proxFinAtencionTrabajador6 == reloj) {
                
                //Si habia algo en cola la disminuyo, y genero una nueva atencion
                if (prevColaE3 != 0) {
                    colaE3--;
                    rndTrabajador6 = Math.random();
                    TiempoDeAtencionTrabajador6 = paraE3.calcularTiempo(rndTrabajador6);
                    proxFinAtencionTrabajador6 = reloj + TiempoDeAtencionTrabajador6;

                    //Si alguna de las tareas que estaban en el vector de tareas estaba en cola, y su posicion era 1, quiere decir que es la que esta tomando el trabajador 6
                    if (control > 0) {
                        for (Tarea vecTarea : vecTareas) {
                            if (vecTarea.getPosicion() == 1 && vecTarea.getEstado() == EstadoTareas.EnColaE3) {
                                vecTarea.setEstado(EstadoTareas.ProcesandoE3T6);
                                vecTarea.setPosicion(0);
                                vecTarea.setHoraFinEventoActual(proxFinAtencionTrabajador6);
                            } //Al resto de las tareas en cola E3, le disminuyo en 1 su posicion.  
                            else if (vecTarea.getEstado() == EstadoTareas.EnColaE3) {
                                int s = vecTarea.getPosicion();
                                vecTarea.setPosicion(s - 1);
                            }
                        }

                    }

                } //Si no hay nada en cola, libero al trabajador 5
                else {
                    estadoT6 = Estado.Libre;
                    rndTrabajador6 = 999999.0;
                    TiempoDeAtencionTrabajador6 = 999999.0;
                    proxFinAtencionTrabajador6 = 999999.0;
                }

            }

            ///////// Proceso despues de finalizar inspeccion ////////////
            
            //Como finalizo la inspeccion, genero un random para ver si vuelve a etapa 1
            rndFinInspE1 = Math.random();
            
            //Si el random generado cae por debajo de 0.1 (10%), vuelve a etapa 1.
            if (rndFinInspE1 <= 0.1) {
                vuelveAEtapa1 = true;
                auxTiempoVuelta = reloj;
                
                //Si alguna de las tareas que estan en el vector corresponde con la actual en base al reloj y su estado, es la que debe volver a la etapa 1
                if (control > 0) {
                    for (Tarea vecTarea : vecTareas) {
                        if (vecTarea.getHoraFinEventoActual() == reloj && (vecTarea.getEstado() == EstadoTareas.ProcesandoE3T4 || vecTarea.getEstado() == EstadoTareas.ProcesandoE3T5 || vecTarea.getEstado() == EstadoTareas.ProcesandoE3T6)) {
                            vecTarea.setEstado(EstadoTareas.VuelveE1);
                            vecTarea.setPosicion(0);
                            vecTarea.setHoraFinEventoActual(reloj);
                        }
                    }

                }

            } //Si no cae debajo de 0.1, genero un nuevo random para ver si vuelve a la etapa 2
            else {
                rndFinInspE2 = Math.random();
                
                //Si el random generado cae por debajo de 0.2 (20%), vuelve a etapa 2.
                if (rndFinInspE2 <= 0.2) {
                    vuelveAEtapa2 = true;
                    auxTiempoVuelta = reloj;
                    
                    //Si alguna de las tareas que estan en el vector corresponde con la actual en base al reloj y su estado, es la que debe volver a la etapa 2
                    if (control > 0) {
                        for (Tarea vecTarea : vecTareas) {
                            if (vecTarea.getHoraFinEventoActual() == reloj && (vecTarea.getEstado() == EstadoTareas.ProcesandoE3T4 || vecTarea.getEstado() == EstadoTareas.ProcesandoE3T5 || vecTarea.getEstado() == EstadoTareas.ProcesandoE3T6)) {
                                vecTarea.setEstado(EstadoTareas.VuelveE2);
                                vecTarea.setPosicion(0);
                                vecTarea.setHoraFinEventoActual(reloj);
                            }
                        }

                    }
                }
                
                //Si no vuelve a ninguna de las dos etapas, quiere decir que termino de manera exitosa.
                if (vuelveAEtapa1 == false && vuelveAEtapa2 == false) {
                    tareasTerminadas++;
                    
                    //Si alguna de las tareas que estan en el vector corresponde con la actual en base al reloj y su estado, es la que finalizo
                    if (control > 0) {
                        for (Tarea vecTarea : vecTareas) {
                            if (vecTarea.getHoraFinEventoActual() == reloj && (vecTarea.getEstado() == EstadoTareas.ProcesandoE3T4 || vecTarea.getEstado() == EstadoTareas.ProcesandoE3T5 || vecTarea.getEstado() == EstadoTareas.ProcesandoE3T6)) {
                                vecTarea.setEstado(EstadoTareas.Finalizada);
                                vecTarea.setPosicion(0);
                                vecTarea.setHoraFinEventoActual(999999.0);
                                vecTarea.setHoraFin(reloj);
                                vecTarea.setTiempoEnSistema(vecTarea.getHoraFin() - vecTarea.getHoraLlegada());
                                control--; //Disminuyo el control en 1, para que cuando llegue a 0 este ciclo y los anteriores no se sigan ejecutando.
                            }
                        }

                    }
                }
            }
        }
        
        //Si alguno de los trabajadores viene de estar ocupado, acumulo su tiempo de ocupacion.
        if (estadoAnteriorT1 == Estado.Ocupado) {
            tiempoOcupacionT1 = tiempoOcupacionT1 + (reloj - tempreloj);
        }
        if (estadoAnteriorT2 == Estado.Ocupado) {
            tiempoOcupacionT2 = tiempoOcupacionT2 + (reloj - tempreloj);
        }
        if (estadoAnteriorT3 == Estado.Ocupado) {
            tiempoOcupacionT3 = tiempoOcupacionT3 + (reloj - tempreloj);
        }
        if (estadoAnteriorT4 == Estado.Ocupado) {
            tiempoOcupacionT4 = tiempoOcupacionT4 + (reloj - tempreloj);
        }
        if (estadoAnteriorT5 == Estado.Ocupado) {
            tiempoOcupacionT5 = tiempoOcupacionT5 + (reloj - tempreloj);
        }
        if (estadoAnteriorT6 == Estado.Ocupado) {
            tiempoOcupacionT6 = tiempoOcupacionT6 + (reloj - tempreloj);
        }

        //Si el random o tiempo de atencion anterior es igual al actual, lo seteo a 999999.0 ya que no necesito seguir manteniendolo en la fila
        if (controlRndLlegada == rndTarea) {
            rndTarea = 999999.0;
        }
        if (controlTEntreLl == tiempoEntreLlegadas) {
            tiempoEntreLlegadas = 999999.0;
        }

        if (controlRndT1 == rndTrabajador1) {
            rndTrabajador1 = 999999.0;
        }
        if (controlTAtT1 == TiempoDeAtencionTrabajador1) {
            TiempoDeAtencionTrabajador1 = 999999.0;
        }

        if (controlRndT2 == rndTrabajador2) {
            rndTrabajador2 = 999999.0;
        }
        if (controlTAtT2 == TiempoDeAtencionTrabajador2) {
            TiempoDeAtencionTrabajador2 = 999999.0;
        }

        if (controlRndT3 == rndTrabajador3) {
            rndTrabajador3 = 999999.0;
        }
        if (controlTAtT3 == TiempoDeAtencionTrabajador3) {
            TiempoDeAtencionTrabajador3 = 999999.0;
        }

        if (controlRndT4 == rndTrabajador4) {
            rndTrabajador4 = 999999.0;
        }
        if (controlTAtT4 == TiempoDeAtencionTrabajador4) {
            TiempoDeAtencionTrabajador4 = 999999.0;
        }

        if (controlRndT5 == rndTrabajador5) {
            rndTrabajador5 = 999999.0;
        }
        if (controlTAtT5 == TiempoDeAtencionTrabajador5) {
            TiempoDeAtencionTrabajador5 = 999999.0;
        }

        if (controlRndT6 == rndTrabajador6) {
            rndTrabajador6 = 999999.0;
        }
        if (controlTAtT6 == TiempoDeAtencionTrabajador6) {
            TiempoDeAtencionTrabajador6 = 999999.0;
        }

        contadorN++;
    }

    private double menorTiempo() {
        double min = Math.min(proxLlegada, proxFinAtencionTrabajador1);
        min = Math.min(min, proxFinAtencionTrabajador2);
        min = Math.min(min, proxFinAtencionTrabajador3);
        min = Math.min(min, proxFinAtencionTrabajador4);
        min = Math.min(min, proxFinAtencionTrabajador5);
        min = Math.min(min, proxFinAtencionTrabajador6);
        min = Math.min(min, auxTiempoVuelta);

        return min;
    }

    private void calcularEventoSiguiente() {
        if (vuelveAEtapa1 == true) {
            e = Evento.VueltaEtapa1;
        } else if (vuelveAEtapa2 == true) {
            e = Evento.VueltaEtapa2;
        } else if (reloj == proxLlegada) {
            e = Evento.LlegaTarea;
        } else if (reloj == proxFinAtencionTrabajador1) {
            e = Evento.FinE1;
        } else if (reloj == proxFinAtencionTrabajador2 || reloj == proxFinAtencionTrabajador3) {
            e = Evento.FinE2;
        } else if (reloj == proxFinAtencionTrabajador4 || reloj == proxFinAtencionTrabajador5 || reloj == proxFinAtencionTrabajador6) {
            e = Evento.FinInspeccion;
        }
    }

    private void generarNuevaLlegadaInicial() {
        rndTarea = Math.random();
        tiempoEntreLlegadas = paraLlegada.calcularTiempo(rndTarea);
        proxLlegada = reloj + tiempoEntreLlegadas;
    }

    public double getReloj() {
        return reloj;
    }

    public void setReloj(double reloj) {
        this.reloj = reloj;
    }

    public Evento getE() {
        return e;
    }

    public void setE(Evento e) {
        this.e = e;
    }

    public int getTarea() {
        return tarea;
    }

    public void setTarea(int tarea) {
        this.tarea = tarea;
    }

    public int getProximaTarea() {
        return proximaTarea;
    }

    public void setProximaTarea(int proximaTarea) {
        this.proximaTarea = proximaTarea;
    }

    public double getRndTarea() {
        return rndTarea;
    }

    public void setRndTarea(double rndTarea) {
        this.rndTarea = rndTarea;
    }

    public int getContadorN() {
        return contadorN;
    }

    public void setContadorN(int contadorN) {
        this.contadorN = contadorN;
    }

    public double getTiempoEntreLlegadas() {
        return tiempoEntreLlegadas;
    }

    public void setTiempoEntreLlegadas(double tiempoEntreLlegadas) {
        this.tiempoEntreLlegadas = tiempoEntreLlegadas;
    }

    public double getProxLlegada() {
        return proxLlegada;
    }

    public void setProxLlegada(double proxLlegada) {
        this.proxLlegada = proxLlegada;
    }

    public Estado getEstadoT1() {
        return estadoT1;
    }

    public void setEstadoT1(Estado estadoT1) {
        this.estadoT1 = estadoT1;
    }

    public double getRndTrabajador1() {
        return rndTrabajador1;
    }

    public void setRndTrabajador1(double rndTrabajador1) {
        this.rndTrabajador1 = rndTrabajador1;
    }

    public double getTiempoDeAtencionTrabajador1() {
        return TiempoDeAtencionTrabajador1;
    }

    public void setTiempoDeAtencionTrabajador1(double TiempoDeAtencionTrabajador1) {
        this.TiempoDeAtencionTrabajador1 = TiempoDeAtencionTrabajador1;
    }

    public double getProxFinAtencionTrabajador1() {
        return proxFinAtencionTrabajador1;
    }

    public void setProxFinAtencionTrabajador1(double proxFinAtencionTrabajador1) {
        this.proxFinAtencionTrabajador1 = proxFinAtencionTrabajador1;
    }

    public int getColaE1() {
        return colaE1;
    }

    public void setColaE1(int colaE1) {
        this.colaE1 = colaE1;
    }

    public Estado getEstadoT2() {
        return estadoT2;
    }

    public void setEstadoT2(Estado estadoT2) {
        this.estadoT2 = estadoT2;
    }

    public double getRndTrabajador2() {
        return rndTrabajador2;
    }

    public void setRndTrabajador2(double rndTrabajador2) {
        this.rndTrabajador2 = rndTrabajador2;
    }

    public double getTiempoDeAtencionTrabajador2() {
        return TiempoDeAtencionTrabajador2;
    }

    public void setTiempoDeAtencionTrabajador2(double TiempoDeAtencionTrabajador2) {
        this.TiempoDeAtencionTrabajador2 = TiempoDeAtencionTrabajador2;
    }

    public double getProxFinAtencionTrabajador2() {
        return proxFinAtencionTrabajador2;
    }

    public void setProxFinAtencionTrabajador2(double proxFinAtencionTrabajador2) {
        this.proxFinAtencionTrabajador2 = proxFinAtencionTrabajador2;
    }

    public Estado getEstadoT3() {
        return estadoT3;
    }

    public void setEstadoT3(Estado estadoT3) {
        this.estadoT3 = estadoT3;
    }

    public double getRndTrabajador3() {
        return rndTrabajador3;
    }

    public void setRndTrabajador3(double rndTrabajador3) {
        this.rndTrabajador3 = rndTrabajador3;
    }

    public double getTiempoDeAtencionTrabajador3() {
        return TiempoDeAtencionTrabajador3;
    }

    public void setTiempoDeAtencionTrabajador3(double TiempoDeAtencionTrabajador3) {
        this.TiempoDeAtencionTrabajador3 = TiempoDeAtencionTrabajador3;
    }

    public double getProxFinAtencionTrabajador3() {
        return proxFinAtencionTrabajador3;
    }

    public void setProxFinAtencionTrabajador3(double proxFinAtencionTrabajador3) {
        this.proxFinAtencionTrabajador3 = proxFinAtencionTrabajador3;
    }

    public int getColaE2() {
        return colaE2;
    }

    public void setColaE2(int colaE2) {
        this.colaE2 = colaE2;
    }

    public Estado getEstadoT4() {
        return estadoT4;
    }

    public void setEstadoT4(Estado estadoT4) {
        this.estadoT4 = estadoT4;
    }

    public double getRndTrabajador4() {
        return rndTrabajador4;
    }

    public void setRndTrabajador4(double rndTrabajador4) {
        this.rndTrabajador4 = rndTrabajador4;
    }

    public double getTiempoDeAtencionTrabajador4() {
        return TiempoDeAtencionTrabajador4;
    }

    public void setTiempoDeAtencionTrabajador4(double TiempoDeAtencionTrabajador4) {
        this.TiempoDeAtencionTrabajador4 = TiempoDeAtencionTrabajador4;
    }

    public double getProxFinAtencionTrabajador4() {
        return proxFinAtencionTrabajador4;
    }

    public void setProxFinAtencionTrabajador4(double proxFinAtencionTrabajador4) {
        this.proxFinAtencionTrabajador4 = proxFinAtencionTrabajador4;
    }

    public Estado getEstadoT5() {
        return estadoT5;
    }

    public void setEstadoT5(Estado estadoT5) {
        this.estadoT5 = estadoT5;
    }

    public double getRndTrabajador5() {
        return rndTrabajador5;
    }

    public void setRndTrabajador5(double rndTrabajador5) {
        this.rndTrabajador5 = rndTrabajador5;
    }

    public double getTiempoDeAtencionTrabajador5() {
        return TiempoDeAtencionTrabajador5;
    }

    public void setTiempoDeAtencionTrabajador5(double TiempoDeAtencionTrabajador5) {
        this.TiempoDeAtencionTrabajador5 = TiempoDeAtencionTrabajador5;
    }

    public double getProxFinAtencionTrabajador5() {
        return proxFinAtencionTrabajador5;
    }

    public void setProxFinAtencionTrabajador5(double proxFinAtencionTrabajador5) {
        this.proxFinAtencionTrabajador5 = proxFinAtencionTrabajador5;
    }

    public Estado getEstadoT6() {
        return estadoT6;
    }

    public void setEstadoT6(Estado estadoT6) {
        this.estadoT6 = estadoT6;
    }

    public double getRndTrabajador6() {
        return rndTrabajador6;
    }

    public void setRndTrabajador6(double rndTrabajador6) {
        this.rndTrabajador6 = rndTrabajador6;
    }

    public double getTiempoDeAtencionTrabajador6() {
        return TiempoDeAtencionTrabajador6;
    }

    public void setTiempoDeAtencionTrabajador6(double TiempoDeAtencionTrabajador6) {
        this.TiempoDeAtencionTrabajador6 = TiempoDeAtencionTrabajador6;
    }

    public double getProxFinAtencionTrabajador6() {
        return proxFinAtencionTrabajador6;
    }

    public void setProxFinAtencionTrabajador6(double proxFinAtencionTrabajador6) {
        this.proxFinAtencionTrabajador6 = proxFinAtencionTrabajador6;
    }

    public int getColaE3() {
        return colaE3;
    }

    public void setColaE3(int colaE3) {
        this.colaE3 = colaE3;
    }

    public double getRndFinInspE1() {
        return rndFinInspE1;
    }

    public void setRndFinInspE1(double rndFinInspE1) {
        this.rndFinInspE1 = rndFinInspE1;
    }

    public boolean isVuelveAEtapa1() {
        return vuelveAEtapa1;
    }

    public void setVuelveAEtapa1(boolean vuelveAEtapa1) {
        this.vuelveAEtapa1 = vuelveAEtapa1;
    }

    public double getRndFinInspE2() {
        return rndFinInspE2;
    }

    public void setRndFinInspE2(double rndFinInspE2) {
        this.rndFinInspE2 = rndFinInspE2;
    }

    public boolean isVuelveAEtapa2() {
        return vuelveAEtapa2;
    }

    public void setVuelveAEtapa2(boolean vuelveAEtapa2) {
        this.vuelveAEtapa2 = vuelveAEtapa2;
    }

    public int getTareasTerminadas() {
        return tareasTerminadas;
    }

    public void setTareasTerminadas(int tareasTerminadas) {
        this.tareasTerminadas = tareasTerminadas;
    }

    public double getTiempoOcupacionT1() {
        return tiempoOcupacionT1;
    }

    public void setTiempoOcupacionT1(double tiempoOcupacionT1) {
        this.tiempoOcupacionT1 = tiempoOcupacionT1;
    }

    public double getTiempoOcupacionT2() {
        return tiempoOcupacionT2;
    }

    public void setTiempoOcupacionT2(double tiempoOcupacionT2) {
        this.tiempoOcupacionT2 = tiempoOcupacionT2;
    }

    public double getAuxTiempoVuelta() {
        return auxTiempoVuelta;
    }

    public void setAuxTiempoVuelta(double auxTiempoVuelta) {
        this.auxTiempoVuelta = auxTiempoVuelta;
    }

    public Tarea[] getVecTareas() {
        return vecTareas;
    }

    public void setVecTareas(Tarea[] vecTareas) {
        this.vecTareas = vecTareas;
    }

    public int getContLlegadas() {
        return contLlegadas;
    }

    public void setContLlegadas(int contLlegadas) {
        this.contLlegadas = contLlegadas;
    }

    public double getTiempoOcupacionT3() {
        return tiempoOcupacionT3;
    }

    public void setTiempoOcupacionT3(double tiempoOcupacionT3) {
        this.tiempoOcupacionT3 = tiempoOcupacionT3;
    }

    public double getTiempoOcupacionT4() {
        return tiempoOcupacionT4;
    }

    public void setTiempoOcupacionT4(double tiempoOcupacionT4) {
        this.tiempoOcupacionT4 = tiempoOcupacionT4;
    }

    public double getTiempoOcupacionT5() {
        return tiempoOcupacionT5;
    }

    public void setTiempoOcupacionT5(double tiempoOcupacionT5) {
        this.tiempoOcupacionT5 = tiempoOcupacionT5;
    }

    public double getTiempoOcupacionT6() {
        return tiempoOcupacionT6;
    }

    public void setTiempoOcupacionT6(double tiempoOcupacionT6) {
        this.tiempoOcupacionT6 = tiempoOcupacionT6;
    }

    public IActividad getCalcActividadEnsamble() {
        return calcActividadEnsamble;
    }

    public void setCalcActividadEnsamble(IActividad calcActividadEnsamble) {
        this.calcActividadEnsamble = calcActividadEnsamble;
    }

    public IActividad getParaLlegada() {
        return paraLlegada;
    }

    public void setParaLlegada(IActividad paraLlegada) {
        this.paraLlegada = paraLlegada;
    }

    public IActividad getParaE1() {
        return paraE1;
    }

    public void setParaE1(IActividad paraE1) {
        this.paraE1 = paraE1;
    }

    public IActividad getParaE2() {
        return paraE2;
    }

    public void setParaE2(IActividad paraE2) {
        this.paraE2 = paraE2;
    }

    public IActividad getParaE3() {
        return paraE3;
    }

    public void setParaE3(IActividad paraE3) {
        this.paraE3 = paraE3;
    }

}
