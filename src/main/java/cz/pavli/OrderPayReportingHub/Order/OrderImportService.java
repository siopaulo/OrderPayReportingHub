package cz.pavli.OrderPayReportingHub.Order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderImportService {

    private final OrderRepository orderRepository;

    public void importCsv(MultipartFile file) {

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            String line;
            boolean header = true;

            while ((line = reader.readLine()) != null) {

                if (header) {
                    header = false;
                    continue;
                }

                if (line.isBlank()) continue;

                String[] columns = line.split(",");

                if (columns.length < 5) continue;

                Order order = Order.builder()
                        .id(UUID.fromString(columns[0].trim()))
                        .type(columns[1].trim())
                        .state(columns[2].trim())
                        .description(columns[3].trim())
                        .createdAt(Instant.parse(columns[4].trim()))
                        .build();

                orderRepository.save(order);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to import CSV", e);
        }
    }
}