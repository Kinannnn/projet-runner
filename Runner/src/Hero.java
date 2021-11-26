import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing{
    int tabmaxindex[]={5,1,5,1};
    int tab_x0[]={20,95,175,272,348,426};            //ligne etat 0 courrir
    int tab_x1[]={20,95};                                //ligne etat 1 sauter
    int tab_x2[]={10,85,165,268,338,416};
    int tab_x3[]={20,95};
    int etat;
    public int gravite=10000;
    public int xhero=0;
    public int yhero=255;
    public int vxhero;
    public int vyhero;
    public int axhero = 100;
    public int ayhero;
    double compteur;
    public int isJumping;
    public int autorise_jump=1;
    public Hero (String a, double x, double y, int etat)
    {
       super(a,x,y,75,100,20,0,16000000);
       this.etat=etat;
      // maximum_index=tabmaxindex[etat];

  }
  public void jump ()
  {
      etat=1;
      ayhero=-10000;
      isJumping=1;
      autorise_jump=0;
  }


    public void update(long time)
    {
        switch(etat)
        {
            case 0 :                                                                        //etat:courrir
                sprite.setViewport(new Rectangle2D(tab_x0[index],0,75,100));
                break;
            case 1 :                                                                           //etat:saut
                if(isJumping==1)
                {sprite.setViewport(new Rectangle2D(tab_x1[0],160,75,100));}
                else
                {
                    sprite.setViewport(new Rectangle2D(tab_x1[1],160,75,100));
                }

                break;
            case 2:                                                                         //etat : courrir+tir
                sprite.setViewport(new Rectangle2D(tab_x2[index],326,75,100));
                break;
            case 3:                                                                         //etat : saut+tir
                sprite.setViewport(new Rectangle2D(tab_x3[index],490,75,100));
                break;
        }


        if(yhero<110)
        {
            isJumping=0;
            ayhero=gravite;

        }
        if(yhero>210)
        {
            yhero=210;
            ayhero=0;
            etat=0;
            vyhero=0;
            autorise_jump=1;
        }

       // sprite.setViewport(new Rectangle2D(tab_x0[index],0,75,100));
        maximum_index=tabmaxindex[etat];
       compteur++;
       if((compteur%5)==0)
       {
           index++;                                         //passage entre les images
       }

        if(index>maximum_index)
        {
            index=0;
        }



        vxhero=500;//+=axhero*0.016;
        xhero+=vxhero*0.016;

        vyhero+=ayhero*0.016;
        yhero+=vyhero*0.016;

        sprite.setY(yhero);
        System.out.println(etat);
        //System.out.println(xhero);
    }
}
