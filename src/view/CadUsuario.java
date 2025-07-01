package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.components.PainelBotoes;
import view.components.Sidebar;


public class CadUsuario extends Application {


    public static void main(String[] args) {
        launch(args);//inicializa o JAVAFX

    }

    @Override
    public void start(Stage janela) throws Exception {

        PainelBotoes botoes = new PainelBotoes();
        Sidebar menu = new Sidebar();
//      class    objeto   construtor

        //carregar imagem
        Image imgLogo = new Image(getClass().getResourceAsStream
                ("/view/resources/img/Logo2.jpeg"));

        Image imgFuncionario = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon-funcionario.png"));

        //Carregamento das fontes
        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/"
                + "RobotoCondensed-Regular.ttf"), 14);

        Font fontNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/"
                + "RobotoCondensed-ExtraBold.ttf"), 15);

        //Criaçao de um container principal MainPane
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);

        ImageView viewImgFuncionario = new ImageView(imgFuncionario);
        viewImgFuncionario.setFitWidth(20);
        viewImgFuncionario.setFitHeight(20);


        Label lblTitulo = new Label("Cadastro de funcionarios"); //titulo
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-text-fill: #a87e08"); //define cor
        lblTitulo.setFont(Font.font(fontNegrito.getFamily(), 25));//fonte


        HBox tituloBox = new HBox(viewImgFuncionario, lblTitulo);
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(10); //Espaço
        tituloBox.setPadding(new Insets(20, 20, 20, 20)); //Espaçamento
        tituloBox.setAlignment(Pos.CENTER);

        Label lblNome = new Label("NOME: ");
        TextField txtNome = new TextField();
        lblNome.setFont(Font.font(fontRegular.getFamily(), 12));
        txtNome.setFont(Font.font(fontRegular.getFamily(), 12));
        //txtNome.setMaxWidth(200);

        Label lblSenha = new Label("SENHA: ");
        TextField txtSenha = new TextField();
        lblSenha.setFont(Font.font(fontRegular.getFamily(), 12));
        txtSenha.setFont(Font.font(fontRegular.getFamily(), 12));
        //txtSenha.setMaxWidth(200);


        Label lblEmail = new Label("EMAIL: ");
        TextField txtEmail = new TextField();
        lblEmail.setFont(Font.font(fontRegular.getFamily(), 12));
        txtEmail.setFont(Font.font(fontRegular.getFamily(), 12));
        //txtEmail.setMaxWidth(200);

        Label lblCargo = new Label("CARGO: ");
        lblCargo.setFont(Font.font(fontRegular.getFamily(), 12));
        //txtCargo.setMaxWidth(200);

        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione:");

        ComboBox<String> boxCargo = new ComboBox<>();
        boxCargo.getItems().addAll("Cozinha", "T.I", "Limpeza", "Portaria", "Recepção",
                "Segurança", "Manutenção");
        boxCargo.setPromptText("Selecione:");


        GridPane FormGrid = new GridPane();
        FormGrid.add(txtNome, 1, 0);
        FormGrid.add(lblNome, 0, 0);

        FormGrid.add(lblEmail, 0, 1);
        FormGrid.add(txtEmail, 1, 1);
        FormGrid.add(boxEmail, 2, 1); //Selecionar

        FormGrid.add(txtSenha, 1, 2);
        FormGrid.add(lblSenha, 0, 2);

        FormGrid.add(lblCargo, 0, 3);
        FormGrid.add(boxCargo, 1, 3); //Selecionar

        FormGrid.add(botoes, 1, 4);//Chamando os botoes

        FormGrid.setPadding(new Insets(20, 20, 20, 20));

        FormGrid.setAlignment(Pos.CENTER);//Centraliza os elementos
        FormGrid.setHgap(10); // Espaço/Lacuna Horizontal
        FormGrid.setVgap(10); // Espaço/Lacuna Vertical


        VBox layout = new VBox(10, tituloBox, FormGrid); //Layout inteiro
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 800, 500);
        //                                  Largura  Altura

        janela.setTitle("Grand hotel"); //Titulo da janela

        //icone da janela
        janela.getIcons().add(imgLogo);
        janela.setScene(scene);
        janela.setResizable(false); //impede ela de redimencionar
        janela.show();

    }
}
