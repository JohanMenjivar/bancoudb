package GrupoDeProductosInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.udb.productosBancarios.Entity.GrupoDeProductos;
import com.udb.productosBancarios.Repository.GrupoDeProductosRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final GrupoDeProductosRepository grupoDeProductosRepository;

    public DataInitializer(GrupoDeProductosRepository grupoDeProductosRepository) {
        this.grupoDeProductosRepository = grupoDeProductosRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Verificar si la tabla está vacía antes de insertar datos
        if (grupoDeProductosRepository.count() == 0) {
            grupoDeProductosRepository.save(new GrupoDeProductos(1L, "Silver", "Paquete Silver con beneficios básicos.", null));
            grupoDeProductosRepository.save(new GrupoDeProductos(2L, "Gold", "Paquete Gold con beneficios intermedios.", null));
            grupoDeProductosRepository.save(new GrupoDeProductos(3L, "Platino", "Paquete Platino con beneficios avanzados.", null));
            grupoDeProductosRepository.save(new GrupoDeProductos(4L, "Black", "Paquete Black con beneficios exclusivos.", null));
        }
    }
}