package com.mycompany.app.treasuremap.objects;

import com.mycompany.app.treasuremap.enums.Code;
import lombok.Getter;

@Getter
public non-sealed class Treasure extends Base {

    private final int quantity;

    public Treasure(Code code, int abscissa, int ordinate, int quantity) {
        super(code, abscissa, ordinate);
        this.quantity = quantity;
    }
}
