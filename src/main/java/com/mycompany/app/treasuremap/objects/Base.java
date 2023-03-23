package com.mycompany.app.treasuremap.objects;

import com.mycompany.app.treasuremap.enums.Code;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@RequiredArgsConstructor
public abstract sealed class Base permits Mountain, Treasure {

    protected final Code code;
    protected final int abscissa;
    protected final int ordinate;
}
