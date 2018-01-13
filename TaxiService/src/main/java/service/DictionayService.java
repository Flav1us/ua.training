package service;

import java.util.ArrayList;

import dao.DictionayDao;
import entity.CarType;

public class DictionayService {

	public ArrayList<CarType> getCarType(String lang) {
		System.out.println("lang = " + lang);

		return (new DictionayDao()).findCarType(lang);
	}
}
