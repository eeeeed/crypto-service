package com.cryptoserver.models;

import com.cryptoserver.util.JsonUtil;

abstract public class BaseModel {

/*------------------------------------------------------------------------------
 * Abstract
 -----------------------------------------------------------------------------*/
    abstract public String toString();


/*------------------------------------------------------------------------------
 * Protected
 -----------------------------------------------------------------------------*/
    protected String toString(BaseModel model) {

        return JsonUtil.toString(model);
    }

}
