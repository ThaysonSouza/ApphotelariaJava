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


public class CadCliente extends Application {


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
        Image imgUserBlack = new Image(getClass().getResourceAsStream
                ("/view/resources/img/imgUserBlack.png"));

        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/"
                + "RobotoCondensed-Regular.ttf"), 14);
        Font fontNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/"
                + "RobotoCondensed-ExtraBold.ttf"), 15);

        //Criaçao de um container principal MainPane
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);

        ImageView ImgUserBlack = new ImageView(imgUserBlack);
        ImgUserBlack.setFitWidth(20);
        ImgUserBlack.setFitHeight(20);

        //titulo
        Label lblTitulo = new Label("Cadastro de Cliente");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-text-fill: #a87e08");
        lblTitulo.setFont(Font.font(fontNegrito.getFamily(), 25));

        HBox tituloBox = new HBox(ImgUserBlack, lblTitulo);
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(10); //Espaço
        tituloBox.setPadding(new Insets(20, 20, 20, 20)); //Espaçamento
        tituloBox.setAlignment(Pos.CENTER);

        Label lblNome = new Label("NOME: ");
        TextField txtNome = new TextField();
        lblNome.setFont(Font.font(fontRegular.getFamily(), 12));
        txtNome.setFont(Font.font(fontRegular.getFamily(), 12));
        txtNome.setMaxWidth(200);

        Label lblCpf = new Label("CPF: ");
        TextField txtCpf = criarMascaraCampo("###.###.###-##");
        lblCpf.setFont(Font.font(fontRegular.getFamily(), 12));
        txtCpf.setFont(Font.font(fontRegular.getFamily(), 12));
        txtCpf.setMaxWidth(200);

        Label lblEmail = new Label("EMAIL: ");
        TextField txtEmail = new TextField();
        lblEmail.setFont(Font.font(fontRegular.getFamily(), 12));
        txtEmail.setFont(Font.font(fontRegular.getFamily(), 12));
        txtEmail.setMaxWidth(200);

        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione:");

        Label lblTelefone = new Label("TELEFONE: ");
        TextField txtTelefone = criarMascaraCampo("(##) #####-####");
        lblTelefone.setFont(Font.font(fontRegular.getFamily(), 12));
        txtTelefone.setFont(Font.font(fontRegular.getFamily(), 12));
        txtTelefone.setMaxWidth(200);

        ComboBox<String> boxTelefone = new ComboBox<>();
        boxTelefone.getItems().addAll("(__)___-___");

        GridPane FormGrid = new GridPane();
        FormGrid.add(txtNome, 1, 0);
        FormGrid.add(lblNome, 0, 0);

        FormGrid.add(txtCpf, 1, 1);
        FormGrid.add(lblCpf, 0, 1);

        FormGrid.add(txtTelefone, 1, 3);
        FormGrid.add(lblTelefone, 0, 3);

        FormGrid.add(lblEmail, 0, 2);
        FormGrid.add(txtEmail, 1, 2);
        FormGrid.add(boxEmail, 2, 2); //Selecionar

        FormGrid.setPadding(new Insets(20, 20, 20, 20));

        FormGrid.setAlignment(Pos.CENTER);//Centraliza os elementos
        FormGrid.setHgap(10); // Espaço/Lacuna Horizontal
        FormGrid.setVgap(10); // Espaço/Lacuna Vertical


        FormGrid.add(botoes, 1, 4);//Chamando os botoes

        VBox layout = new VBox(10, tituloBox, FormGrid); //Layout inteiro
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 800, 500);
        //Largura   Altura

        janela.setTitle("Grand hotel"); //Titulo da janela

        //icone da janela
        janela.getIcons().add(imgLogo);
        janela.setScene(scene);
        janela.setResizable(false); //impede ela de redimencionar
        janela.show();
    }


    //Metodo para criar um campo de texto com mascara
    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) ->
        {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;
            for (char caracter : mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    } else {
                        break;
                    }
                } else {
                    formatacaoCampo.append(caracter);
                }
            }
            txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }
// the movie database
}
