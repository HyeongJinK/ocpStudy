package khj.study.shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductCheckResult {
    boolean check;
    String message;
}
