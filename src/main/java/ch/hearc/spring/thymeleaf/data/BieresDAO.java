package ch.hearc.spring.thymeleaf.data;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ch.hearc.spring.thymeleaf.model.Biere;
import ch.hearc.spring.thymeleaf.model.Etudiant;


public class BieresDAO {
	
	private static Map<Integer, Biere> bieres = new HashMap<>();
	
	static {
		
		bieres.put(1, new Biere(1,"Mandragore",new BigDecimal("3.95"),"BFM",12));
		bieres.put(2, new Biere(2,"Saint-Bon-Chieb",new BigDecimal("5.95"),"BFM",9));
		
		
	}

	public List<Biere> getAllBieres() {
		return bieres.values().stream().collect(Collectors.toList());
	}
	
	public void save(Biere biere) {
		int nextKey = nextKey();
		biere.setId(nextKey);
		bieres.put(nextKey, biere);
	}
	
	private static Integer nextKey() {
		final Comparator<Integer> comp = (k1, k2) -> Integer.compare( k1, k2);
	    
		return bieres.keySet().stream().max(comp).get() + 1;
	}

	public void deleteBiere(Integer id) {
		bieres.remove(id);
		System.out.println(bieres.keySet().size());
		
	}
}
