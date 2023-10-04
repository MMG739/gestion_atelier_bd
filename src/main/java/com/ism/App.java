package com.ism;
import com.ism.entities.Categorie;
import com.ism.repositories.ITables;
import com.ism.repositories.bd.CategorieRepository;
import com.ism.repositories.list.TableCategories;
import com.ism.services.CategorieService;
import com.ism.services.CategorieServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ITables<Categorie> repository=new CategorieRepository();
        CategorieServiceImpl categorieServiceImpl=new CategorieServiceImpl(repository);
       int choix;
       Scanner scanner=new Scanner(System.in);
       do{
           System.out.println("-------App---------");
           System.out.println("1-Ajouter");
           System.out.println("2-Lister");
           System.out.println("3-supprimer");
           System.out.println("4-Modifier");
           System.out.println("5-Quitter");
           choix= scanner.nextInt();
           scanner.nextLine();

           switch (choix){
               case 1:
                   System.out.println("Entrez le libelle");
                   Categorie categorie=new Categorie(scanner.nextLine());
                   categorieServiceImpl.add(categorie);
                   break;
               case 2:
                  categorieServiceImpl.getAll().forEach(System.out::println);
                   break;
               case 3:
                   categorieServiceImpl.getAll().forEach(System.out::println);
                   System.out.println("Entrez l'id");
                   categorieServiceImpl.remove(scanner.nextInt());
                   break;
               case 4:
                   categorieServiceImpl.getAll().forEach(System.out::println);
                   System.out.println("Entrez l'id");
                   Categorie cat=categorieServiceImpl.show(scanner.nextInt());
                   scanner.nextLine();
                   if (cat!=null){
                       System.out.println("Entrez le new libelle");
                       cat.setLibelle(scanner.nextLine());
                       categorieServiceImpl.update(cat);
                   }
                   break;

               default:
                   break;
           }
           
           
       }while(choix!=5);
    }
}
