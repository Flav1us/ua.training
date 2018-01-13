package dao;

import java.util.ArrayList;

import entity.CarType;

public class DictionayDao {

	public ArrayList<CarType> findCarType(String lang) {
		ArrayList<CarType> types = new ArrayList<CarType>();
		CarType type1 = new CarType();
		type1.setCode(1);
		type1.setType("Стандарт");
		types.add(type1);

		CarType type2 = new CarType();
		type2.setCode(2);
		type2.setType("Универсал");
		types.add(type2);

		CarType type3 = new CarType();
		type3.setCode(3);
		type3.setType("Микроавтобус");
		types.add(type3);

		CarType type4 = new CarType();
		type4.setCode(4);
		type4.setType("Премиум");
		types.add(type4);

		return types;
	}
}
