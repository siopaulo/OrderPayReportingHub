package cz.pavli.OrderPayReportingHub.Order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/orders")
public class OrderImportController {

    private final OrderImportService importService;

    public OrderImportController(OrderImportService importService) {
        this.importService = importService;
    }

    @PostMapping("/import")
    public ResponseEntity<String> importOrders(@RequestParam("file") MultipartFile file) {
        importService.importCsv(file);
        return ResponseEntity.ok("Import successful");
    }
}