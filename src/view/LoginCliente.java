package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginCliente extends Application {

    @Override

    public void start(Stage janela) {

        Image imgLogo = new Image(getClass().getResourceAsStream
                ("/view/resources/img/Logo2.jpeg"));
        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/"
                + "RobotoCondensed-Regular.ttf"), 14);
        Font fontNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/"
                + "RobotoCondensed-ExtraBold.ttf"), 15);

        Image eyeOpen = new Image(getClass().getResourceAsStream("/view/resources/img/olhoAberto.png"));
        Image eyeClosed = new Image(getClass().getResourceAsStream("/view/resources/img/olhoFechado.png"));

        ImageView viewImgEyeOpen = new ImageView(eyeOpen);
        viewImgEyeOpen.setFitWidth(20);
        viewImgEyeOpen.setFitHeight(20);
        ImageView viewImgEyeClosed = new ImageView(eyeClosed);
        viewImgEyeClosed.setFitWidth(20);
        viewImgEyeClosed.setFitHeight(20);

                // Lado esquerdo com imagem de fundo
        StackPane esquerda = new StackPane();
        esquerda.setPrefWidth(400);
        esquerda.setStyle("-fx-background-image: url('/view/resources/img/Recepcao.jpg'); -fx-background-repeat: stretch; -fx-background-size: cover");

                // Título
        Label lblTitulo = new Label("Faça seu login");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-text-fill: #a87e08"); //define cor
        lblTitulo.setFont(Font.font(fontNegrito.getFamily(), 35));//fonte

                // Campos
        Label lblUsuario = new Label("Usuário:");
        TextField txtUsuario = new TextField();
        txtUsuario.setPromptText("Digite seu usuário");
        lblUsuario.setFont(Font.font(fontRegular.getFamily(), 13));
        txtUsuario.setFont(Font.font(fontRegular.getFamily(), 13));


        Label lblSenha = new Label("Senha:");
        lblSenha.setFont(Font.font(fontRegular.getFamily(), 13));

        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");

        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Digite sua senha");
        txtSenha.setVisible(false);
        txtSenha.setManaged(false);

        Button btnEyeOpen = new Button();
        btnEyeOpen.setGraphic(viewImgEyeOpen);
        btnEyeOpen.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
        btnEyeOpen.setMaxSize(15,15);

        StackPane senha123 = new StackPane();
        senha123.setPrefWidth(200);
        senha123.getChildren().addAll(txtSenha, campoSenha);

        StackPane.setMargin(btnEyeOpen, new Insets(0, 0, 0, 0));


        final boolean[] clicado = {false};
        btnEyeOpen.setOnMouseClicked(evento -> {
            if (clicado[0]) {
                btnEyeOpen.setGraphic(viewImgEyeClosed);
                campoSenha.setText(txtSenha.getText());
                campoSenha.setVisible(true);
                campoSenha.setManaged(true);
                txtSenha.setVisible(false);
            } else {
                btnEyeOpen.setGraphic(viewImgEyeOpen);
                txtSenha.setText(campoSenha.getText());
                txtSenha.setVisible(true);
                txtSenha.setManaged(true);
                campoSenha.setVisible(false);
            }
            clicado[0] = !clicado[0];
        });

                //Botão com estilo
        Button botaoLogin = new Button("Login");
        botaoLogin.setFont(Font.font(fontRegular.getFamily(), 12));
        botaoLogin.setStyle("""

            -fx-background-color: #a87e08;

            -fx-text-fill: white;

            -fx-font-size: 14px;

            -fx-font-weight: bold;

            -fx-background-radius: 20px;

            -fx-padding: 5px 70px;

            -fx-cursor: hand;

        """);

                //Formulário com GridPane
        GridPane gridForm = new GridPane();

        gridForm.setHgap(5);
        gridForm.setVgap(15);
        gridForm.setAlignment(Pos.CENTER);
        gridForm.add(lblUsuario, 0, 0);
        gridForm.add(txtUsuario, 1, 0);
        gridForm.add(lblSenha, 0, 1);
        gridForm.add(senha123, 1, 1);
        gridForm.add(btnEyeOpen, 2, 1);
        gridForm.add(botaoLogin, 1, 2);

        VBox boxLogin = new VBox(20, lblTitulo, gridForm);
        boxLogin.setAlignment(Pos.CENTER);
        boxLogin.setPadding(new Insets(40));
        boxLogin.setStyle("-fx-background-color: #ffffff; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        boxLogin.setPrefWidth(400);

                //layout principal
        HBox layoutPrincipal = new HBox(esquerda, boxLogin);

        Scene scene = new Scene(layoutPrincipal, 750, 500);


        janela.setTitle("Tela de Login");
        janela.setScene(scene);
        janela.getIcons().add(imgLogo);
        janela.show();
        janela.setResizable(false); //impede ela de redimencionar

    }

    public static void main(String[] args) {
        launch(args);
    }
}