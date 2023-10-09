package com.ism;
import com.ism.entities.ArticleConfection;
import com.ism.entities.Categorie;
import com.ism.repositories.ITables;
import com.ism.repositories.bd.ArticleConfectionRepository;
import com.ism.repositories.bd.CategorieRepository;
import com.ism.repositories.list.TableCategories;
import com.ism.services.ArticleConfectionServiceImpl;
import com.ism.services.CategorieService;
import com.ism.services.CategorieServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ITables<Categorie> repository=new CategorieRepository();
        ITables<ArticleConfection> repository1=new ArticleConfectionRepository();
        CategorieServiceImpl categorieServiceImpl=new CategorieServiceImpl(repository);
        ArticleConfectionServiceImpl articleConfectionServiceImpl=new ArticleConfectionServiceImpl(repository1);
       int choix;
       Scanner scanner=new Scanner(System.in);
       do{
           System.out.println("-------App---------");
           System.out.println("1-Ajouter une categorie");
           System.out.println("2-Lister");
           System.out.println("3-supprimer");
           System.out.println("4-Modifier");
           System.out.println("6-Ajouter un article");
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

               case 6:
                   System.out.println("Entrez le libelle");
                   String lib=scanner.nextLine();
                   System.out.println("Entrez la quantité");
                   int qte= scanner.nextInt();
                   System.out.println("Entrez le prix");
                   double prix= scanner.nextDouble();
                   ArticleConfection articleConfection=new ArticleConfection(lib,prix,qte);
                   articleConfectionServiceImpl.add(articleConfection);

               default:
                   break;
           }
           
           
       }while(choix!=5);
    }
}
