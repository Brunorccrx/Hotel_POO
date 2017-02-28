package sistemadehotel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Hotel {

    @SuppressWarnings({"resource"})
    public static void main(String args[]) {
        // TODO toda vez que o sistema for inicializado ira carregar as listas
        // das pessoas no hotel
        // TODO carregar login e senha do gerente de um arquivo

        List<Recepcionista> recepcionistas = new ArrayList<>();
        List<Camareira> camareiras = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        Funcionario gerente = Gerente.getInstance();
        Funcionario r = new Recepcionista();
        Recepcionista recepcionista = new Recepcionista();
        Camareira Objcamareira = new Camareira();
        Scanner entrada = new Scanner(System.in);
        String login;
        String senha;
        Boolean autenticaGerente;
        Boolean autenticaRecepcionista = false;

        Cliente cli = new Cliente();

        try {
            BufferedReader BufRed = new BufferedReader(new FileReader("Relatorio de Consumo.txt"));
            String str = BufRed.readLine();
            while (str != null) {
                StringTokenizer strtok = new StringTokenizer(str);
                while (strtok.hasMoreTokens()) {
                    cli.quarto.setNumeroQuarto(strtok.nextToken(" "));
                    cli.quarto.setAluguelDoQuarto(Double.parseDouble((String) strtok.nextElement()));
                    cli.quarto.setConsumo(Double.parseDouble((String) strtok.nextElement()));
                    cli.quarto.setDanosCausados(Double.parseDouble((String) strtok.nextElement()));
                    cli.quarto.setGastoTotal(Double.parseDouble((String) strtok.nextElement()));
                    clientes.add(cli);
                    str = BufRed.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.printf("\n\t!!! Arquivo não encontrado !!!\n\n");
            // e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }
        /**
         * ******** CARREGAMENTO DE DADOS DOS FUNCIONARIOS.******
         */
        /**
         * DADOS RECEPCIONISTA *
         */
        try {
            BufferedReader BufRed = new BufferedReader(new FileReader("J:\\NetBeansProjects\\Sistema de Hotelaria\\Banco de Dados\\recepcionista.txt"));
            String str = BufRed.readLine();
            while (str != null) {
                StringTokenizer strtok = new StringTokenizer(str);
                while (strtok.hasMoreTokens()) {
                    recepcionista.setNome(strtok.nextToken("/"));
                    recepcionista.setRG(strtok.nextToken("/"));
                    recepcionista.setCPF(strtok.nextToken("/"));
                    recepcionista.setNumTelefone(strtok.nextToken("/"));
                    recepcionista.setDataNasc(strtok.nextToken("/"));
                    recepcionista.setRua(strtok.nextToken("/"));
                    recepcionista.setBairro(strtok.nextToken("/"));
                    recepcionista.setComplemento(strtok.nextToken("/"));
                    recepcionista.setNumeroCasa(strtok.nextToken("/"));
                    recepcionista.setCidade(strtok.nextToken("/"));
                    recepcionista.setEstado(strtok.nextToken("/"));
                    recepcionista.setSalario(Double.parseDouble((String) strtok.nextElement()));

                    recepcionistas.add(recepcionista);
                    str = BufRed.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.printf("\n\t!!! Arquivo não encontrado !!!\n\n");
            // e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }
         /* CARREGAMENTO DOS DADOS DAS CAMAREIRAS */
        try {
            BufferedReader BufRed = new BufferedReader(new FileReader("J:\\NetBeansProjects\\Sistema de Hotelaria\\Banco de Dados\\Camareiras.txt"));
            String str = BufRed.readLine();
            while (str != null) {
                StringTokenizer strtok = new StringTokenizer(str);
                while (strtok.hasMoreTokens()) {
                    Objcamareira.setNome(strtok.nextToken("/"));
                    Objcamareira.setRG(strtok.nextToken("/"));
                    Objcamareira.setCPF(strtok.nextToken("/"));
                    Objcamareira.setNumTelefone(strtok.nextToken("/"));
                    Objcamareira.setDataNasc(strtok.nextToken("/"));
                    Objcamareira.setRua(strtok.nextToken("/"));
                    Objcamareira.setBairro(strtok.nextToken("/"));
                    Objcamareira.setComplemento(strtok.nextToken("/"));
                    Objcamareira.setNumeroCasa(strtok.nextToken("/"));
                    Objcamareira.setCidade(strtok.nextToken("/"));
                    Objcamareira.setEstado(strtok.nextToken("/"));
                    Objcamareira.setSalario(Double.parseDouble((String) strtok.nextElement()));

                    camareiras.add(Objcamareira);
                    str = BufRed.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.printf("\n\t!!! Arquivo não encontrado !!!\n\n");
            // e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }
        /** CARREGAMENTO DOS DADOS DOS CLIENTES **/ 
        try {
            BufferedReader BufRed = new BufferedReader(new FileReader("C:\\Users\\PIRES\\Downloads\\Sistema de Hotelaria\\Banco de Dados Clientes\\Clientes.txt"));
            String str = BufRed.readLine();
            while (str != null) {
                StringTokenizer strtok = new StringTokenizer(str);
                while (strtok.hasMoreTokens()) {
                   cli.setNome(strtok.nextToken("/"));
                   cli.setNacionalidade(strtok.nextToken("/"));
                   if(cli.getNacionalidade().equals("BRASILEIRO")){
                       cli.setCPF(strtok.nextToken("/"));
                       cli.setRG(strtok.nextToken("/"));
                       cli.setDataNasc(strtok.nextToken("/"));
                       cli.setNumTelefone(strtok.nextToken("/"));
                       cli.setRua(strtok.nextToken("/"));
                       cli.setBairro(strtok.nextToken("/"));
                       cli.setComplemento(strtok.nextToken("/"));
                       cli.setNumeroCasa(strtok.nextToken("/"));
                       cli.setCidade(strtok.nextToken("/"));
                       cli.setEstado(strtok.nextToken("/"));
                   }else{
                       cli.setPassaporte(strtok.nextToken("/"));
                       cli.setDataNasc(strtok.nextToken("/"));
                       cli.setNumTelefone(strtok.nextToken("/"));
                       cli.setRua(strtok.nextToken("/"));
                       cli.setBairro(strtok.nextToken("/"));
                       cli.setComplemento(strtok.nextToken("/"));
                       cli.setNumeroCasa(strtok.nextToken("/"));
                       cli.setCidade(strtok.nextToken("/"));
                       cli.setEstado(strtok.nextToken("/"));
                    }
                    clientes.add(cli);
                    str = BufRed.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.printf("\n\t!!! Arquivo não encontrado !!!\n\n");
            // e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }

        System.out.println("*** BEM VINDO AO SISTEMA ***");
        while (true) {
            System.out.print("Login: ");
            login = entrada.next();
            System.out.print("Senha: ");
            senha = entrada.next();

            autenticaGerente = ((Gerente) gerente).autentica(senha, login);
            if (autenticaGerente) {
                System.out.println("** GERENCIA **");
                break;
            } else if (recepcionista.autentica(senha, login)) {
                System.out.println("** RECEPÇÃO **");
                autenticaRecepcionista = true;
                break;
            }

            System.out.println("Login ou Senha incorretos");
        }
        if (autenticaGerente) {
            int n = 0;
            while (n != 5) {
                System.out.println("1- CADASTRO DE FUNCIONARIOS  2 - REMOÇÃO  3- ALTERAÇÃO 4 - MOSTRAR FUNCIONARIOS 5-SALVAR E SAIR");
                System.out.print("Opção: ");
                n = entrada.nextInt();
                entrada.nextLine();// Ler Enter
                if (n == 1) {// CADASTRO DE FUNCIONARIOS
                    while (true) {
                        System.out.println("1 - CADASTRO DE RECEPCIONISTA  2 - CADASTRO DE CAMAREIRA  3 - VOLTAR");
                        n = entrada.nextInt();
                        entrada.nextLine();
                        if (n == 1) {// Opção de Cadastrar Recepcionistas
                            //Funcionario r = new Recepcionista();
                            ((Gerente) gerente).cadastrarFuncionarioRecepcionista(recepcionistas, (Recepcionista) r);
                        } else if (n == 2) { // Opção de Cadastrar Camareiras
                            Funcionario camareira = new Camareira();
                            ((Gerente) gerente).cadastrarFuncionarioCamareira(camareiras, (Camareira) camareira);
                        } else if (n == 3) {
                            break;
                        }
                        System.out.println("*** CADASTRO REALIZADO COM SUCESSO ***");
                        System.out.println("1 - CADASTRAR OUTRO FUNCIONARIO  2 - NÃO");
                        n = entrada.nextInt();
                        entrada.nextLine();
                        if (n == 2) {
                            break;
                        }

                    }
                } else if (n == 2) {// REMOÇÃO
                    ((Gerente) gerente).removerFuncionario(camareiras, recepcionistas);
                } else if (n == 3) {// Alteração
                    ((Gerente) gerente).alterarFuncionario(camareiras, recepcionistas);
                } else if (n == 4) {
                    ((Gerente) gerente).mostrarFuncionarios(camareiras);
                    ((Gerente) gerente).mostrarFuncionarios(recepcionistas);
                }
            }
        } else if (autenticaRecepcionista) {
            int n = 0;
            while (n != 8) {
                System.out.println("1- CADASTRO DE CLIENTE  2 - REMOÇÃO  3- ALTERAÇÃO  + \n4- MOSTRAR CLIENTES  5 - RESERVAR QUARTO 6 - ALUGAR QUARTO  7 - RESERVA QUARTO");
                System.out.print("Opção: ");
                n = entrada.nextInt();
                entrada.nextLine();// Ler Enter
                if (n == 1) {// CADASTRO DE CLIENTE
                    while (true) {
                        System.out.println("1 - CADASTRO DE CLIENTES  2 - VOLTAR");
                        n = entrada.nextInt();
                        entrada.nextLine();// Ler Enter
                        if (n == 1) {// Opção de Cadastrar Cliente
                            Pessoa cliente = new Cliente();
                            ((Recepcionista) r).cadastrarCliente(clientes, (Cliente) cliente);
                        } else if (n == 2) {
                            break;
                        }
                        System.out.println("*** CADASTRO REALIZADO COM SUCESSO ***");
                        System.out.print("1 - CADASTRAR OUTRO CLIENTE  2 - NÃO\n");
                        n = entrada.nextInt();
                        entrada.nextLine();// Ler Enter
                        if (n == 2) {
                            break;
                        }
                    }
                } else if (n == 2) {// REMOÇÃO
                    
                } else if (n == 3) {// Alteração
                    ((Gerente) gerente).alterarFuncionario(camareiras,recepcionistas);
                } else if (n == 5) {
                    ((Recepcionista) r).mostrarClientes(clientes);
                } else if (n == 6) {//Reservar Quarto
                    ((Recepcionista) r).reservaQuarto();
                }
            }
        }
        //TODO salvar tudo e sair do SISTEMA
        /** SALVAR DADOS DO ARRAY EM ARQUIVO **/
        
        /** DADOS DE CONSUMO **/
        Quarto aux = new Quarto();
        try {
            aux.salvarConsumo(clientes);
        } catch (IOException e) {
            System.out.println("\nIOException\n");
            e.printStackTrace();
        }
        
        /** DADOS DE CADASTRO ( RECEPCIONISTAS ) **/
        Gerente gaux = Gerente.getInstance();
        try {
            gaux.salvarDadosRecepcionista(recepcionistas);
        } catch (IOException e) {
            System.out.println("\nIOException\n");
            e.printStackTrace();
        }
        /** DADOS DE CADASTRO ( CAMAREIRAS ) **/
        try {
            gaux.salvarDadosCamareira(camareiras);
        } catch (IOException e) {
            System.out.println("\nIOException\n");
            e.printStackTrace();
        }
        
        /** DADOS DE CADASTRO ( CLIENTES ) **/
        Recepcionista raux = new Recepcionista();
        try {
            raux.salvarDadosCliente(clientes);
        } catch (IOException e) {
            System.out.println("\nIOException\n");
            e.printStackTrace();
        }
        System.out.println("Todos os dados foram salvos com sucesso!");
    }
}
