package com.cryptoserver.dao;

import com.cryptoserver.models.Symbol;

public interface SymbolDao {

	public Symbol getSymbol(String symbolName);
}
