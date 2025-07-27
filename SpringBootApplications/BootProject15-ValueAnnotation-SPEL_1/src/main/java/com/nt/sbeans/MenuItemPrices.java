package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("menup")
public class MenuItemPrices {
	@Value("${menu.dosarate}")
	private Float dosaPrice;
	
	@Value("${menu.idlyrate}")
	private Float idlyPrice;
	
	@Override
	public String toString() {
		return "MenuItemPrices [dosaPrice=" + dosaPrice + ", idlyPrice=" + idlyPrice + ", pohaPrice=" + pohaPrice
				+ ", vadaPavPrice=" + vadaPavPrice + "]";
	}

	@Value("${menu.poharate}")
	private Float pohaPrice;
	
	@Value("${menu.vprate}")
	private Float vadaPavPrice;

}
