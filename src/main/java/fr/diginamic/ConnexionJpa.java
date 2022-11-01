package fr.diginamic;

import java.beans.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.diginamic.entities.Region;

public class ConnexionJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Scanner in = new Scanner(System.in);          
		
		
		 System.out.print("Ajouter nom de region: ");    
	       String nom = in.next();   
	        System.out.println("Ajouter le code de la region"); 
	        String regId = in.next();  
	        Region region = new Region();
	        
	        
	        System.out.println("Transaction");
			entityManager.getTransaction().begin();
		region.setRegionNom(nom);
		region.setRegion_id(Integer.parseInt(regId));
		entityManager.persist(region);
		entityManager.getTransaction().commit(); //ajouter dans le table
		System.out.println("le variables ete ajoute");
		
		
		
		
		
		//Region reg =(Region) entityManager.find(Region.class, 4);
		System.out.println("Chercher par le code de la region"); 
        String chId = in.next();  
	        String queryString = "select r from Region r where region_id="+chId;
		
	        TypedQuery<Region> query2 = entityManager.createQuery(queryString,
	        		Region.class);
	        		region = query2.getResultList().get(0);

		if (region != null){
			System.out.println(region.getRegionNom());
			}
		
		System.out.println("Changer le nom de Region"); 
		
		String chaNom = in.next();
		 System.out.println("Transaction");
			entityManager.getTransaction().begin();
			region.setRegionNom(chaNom);
		region.setRegion_id((region.getRegion_id()));
		entityManager.persist(region);
		entityManager.getTransaction().commit(); //ajouter dans le table
		System.out.println("le variables ete change");
		
		
System.out.println("Ajouter le code de la region puis supprimer"); 
		
		String chSup = in.next();
		 queryString = "select r from Region r where region_id="+chSup;
			
	        query2 = entityManager.createQuery(queryString,
	        		Region.class);
	        		region = query2.getResultList().get(0);

		if (region != null){
				entityManager.getTransaction().begin();
				
				entityManager.remove(region);
				entityManager.getTransaction().commit();
				System.out.println("Supprime");
		}
		
		System.out.println("Voir le tableau"); 
		
		@SuppressWarnings("unchecked")
		List<Region> listRegion = entityManager.createQuery("select r from Region r").getResultList();

		
			for (Region regl : listRegion) {
				System.out.println(regl.getId()+" ,"+regl.getRegion_id()+" ,"+regl.getRegionNom());
			}
		
	
		
		entityManager.close();
		entityManagerFactory.close();
		
		
		
	}
}