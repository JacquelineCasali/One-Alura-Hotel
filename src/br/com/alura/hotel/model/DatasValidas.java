package br.com.alura.hotel.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DatasValidas {

	public String validarData(Date data) {

		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
		String dataConvertida = formatador.format(data);

		return dataConvertida;

	}

	public long calculaDias(String dataEntrada, String dataSaida) {

		SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date date1 = formatador.parse(dataEntrada);
			Date date2 = formatador.parse(dataSaida);

			long result = Math.abs(date1.getTime() - date2.getTime()) ;
			
			long resultMs = TimeUnit.MINUTES.convert(result, TimeUnit.MILLISECONDS);
			

			return resultMs/1440;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return 0;

	}
}