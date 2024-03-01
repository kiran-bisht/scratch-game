package com.kiranbisht.model.config;

public class StandardSymbolProbability extends SymbolProbability {
    private int column;
    private int row;
    
   
    
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
	
	public StandardSymbolProbability() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "StandardSymbolProbability [column=" + column + ", row=" + row + ", symbols=" + super.getSymbols() + "]";
	}
    
    

}

