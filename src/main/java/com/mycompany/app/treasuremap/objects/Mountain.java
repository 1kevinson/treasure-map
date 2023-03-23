package com.mycompany.app.treasuremap.objects;

import com.mycompany.app.treasuremap.enums.Code;
import lombok.Getter;

@Getter
public non-sealed class Mountain extends Base {

    public Mountain(Code code, int abscissa, int ordinate) {
        super(code, abscissa, ordinate);
    }
}
