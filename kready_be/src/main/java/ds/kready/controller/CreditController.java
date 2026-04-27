package ds.kready.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Credit")
@RequestMapping("credit")
@RestController
@RequiredArgsConstructor
public class CreditController {

}
