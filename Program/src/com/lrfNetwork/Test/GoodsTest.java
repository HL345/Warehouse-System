package com.lrfNetwork.Test;

import java.util.ArrayList;

import com.lrfNetwork.Info.Goods;
import com.lrfNetwork.jdbc.DB_Function;
import com.lrfNetwork.jdbc.GoodsDaoImpl;

public class GoodsTest {
	public static void main(String[] args) {
		/*
		 * c查询所有信息*
		 */
//		ArrayList<Goods> goodsArray=new ArrayList<>();
//		goodsArray=GoodsDaoImpl.getAllGoodsInfo();
//		for (Goods goods : goodsArray) {
//			System.out.println(goods.getId()+"\t"+goods.getName()+"\t"+goods.getType()+"\t"+goods.getSave()+"\t"+goods.getPrice()+"\t"+goods.getSize()+"\t"+goods.getDate()+"\t"+goods.getManufacture()+"\t"+goods.getPeriod());
//		}
		
		
		/*
		 * 插入信息
		 * *
		 */
		
//		Goods goods=new Goods(1001, name, type, save, price, size, date, manufacture, period);
		
		
		/*
		 * limit 分页查询*
		 */
		ArrayList<Goods> goodsArray=new ArrayList<>();
		String SelectInfo="肉";
		goodsArray=GoodsDaoImpl.SelectNeedInfo(SelectInfo);
		for (Goods goods : goodsArray) {
			System.out.println(goods.getId()+"\t"+goods.getName()+"\t"+goods.getType()+"\t"+goods.getSave()+"\t"+goods.getPrice()+"\t"+goods.getSize()+"\t"+goods.getDate()+"\t"+goods.getManufacture()+"\t"+goods.getPeriod());
		}
	}
}
