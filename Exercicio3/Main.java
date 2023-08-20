import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Configuração do servidor Spark
        staticFiles.location("/public");
        port(8080);

        // Rota para renderizar o formulário HTML
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "formulario"));
        });

        // Rota para processar o formulário e exibir os dados
        post("/processar-formulario", (req, res) -> {
            String nomeProduto = req.queryParams("nome");
            double precoProduto = Double.parseDouble(req.queryParams("preco"));

            Map<String, Object> model = new HashMap<>();
            model.put("nome", nomeProduto);
            model.put("preco", precoProduto);

            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "resultado"));
        });
    }
}

