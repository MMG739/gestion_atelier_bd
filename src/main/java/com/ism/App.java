package com.ism;
import com.ism.entities.ArticleConfection;
import com.ism.entities.Categorie;
import com.ism.repositories.bd.ArticleConfRepository;
import com.ism.repositories.bd.CategorieRepository;
import com.ism.repositories.core.Database;
import com.ism.repositories.core.ITables;
import com.ism.repositories.bd.impl.ArticleConfectionRepositoryImpl;
import com.ism.repositories.bd.impl.CategorieRepositoryImpl;
import com.ism.repositories.core.MySQLImpl;
import com.ism.services.ArticleConfectionServiceImpl;
import com.ism.services.CategorieServiceImpl;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Dependence Mysql
        Database database=new MySQLImpl();
        //Repo
        CategorieRepository repository=new CategorieRepositoryImpl(database);
        CategorieServiceImpl categorieServiceImpl=new CategorieServiceImpl(repository);

        ArticleConfRepository repository1=new ArticleConfectionRepositoryImpl(database);
        ArticleConfectionServiceImpl articleConfectionServiceImpl=new ArticleConfectionServiceImpl(repository1);
       int choix;
       Scanner scanner=new Scanner(System.in);
       do{
           System.out.println("-------App---------");
           System.out.println("-------Categorie---------");
           System.out.println("1-Ajouter une categorie");
           System.out.println("2-Lister Categorie");
           System.out.println("3-supprimer Categorie");
           System.out.println("4-Modifier Categorie");
           System.out.println("5-Quitter");
           /*
           System.out.println("-------Article---------");
           System.out.println("6-Ajouter un article");
           System.out.println("7-Lister article");
           System.out.println("8-Supprimer un article");
           System.out.println("9-Modifier un article");
           System.out.println("5-Quitter");

            */

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
               /*
               case 6:
                   System.out.println("Entrez le libelle");
                   String lib=scanner.nextLine();
                   System.out.println("Entrez la quantité");
                   int qte= scanner.nextInt();
                   System.out.println("Entrez le prix");
                   double prix= scanner.nextDouble();
                   System.out.println("Veuillez choisir une categorie");
                   categorieServiceImpl.getAll().forEach(System.out::println);
                   System.out.println("Entrez l'id");
                   Categorie articleCat=categorieServiceImpl.show(scanner.nextInt());
                   scanner.nextLine();
                   ArticleConfection articleConfection=new ArticleConfection(lib,prix,qte,articleCat);
                   articleConfectionServiceImpl.add(articleConfection);
                   break;
               case 7:
                   articleConfectionServiceImpl.getAll().forEach(System.out::println);
                   break;

                */

               default:
                   break;
           }
           
           
       }while(choix!=5);
    }
}
