baug_fragments_exemple1
=======================

Modification de l'exemple List&lt;->Detail proposé par l'ADT afin d'être réellement basé sur 1 Activity et les fragment


Modification du layout :
========================
activity_item_list : \n
<fragment /> ===> <FrameLayout />\n
L'utilisation du framelayout fait qu'en cas de plusieurs add, les fragment s'ajoutent les uns sur les autres\n
pour permettre l'utilisation sur smartphone de la stack des fragments dessus (on aurait pu prendre tous les LinearLayout, RelativeLayout,... à la place)\n

Toutes les modifications ont eu lieu dans l'activity ItemListActivity :
=======================================================================

onCreate\n
après le if()\n
ajout d'un else (smartphones!)\n
>>
récupération du fragment affiche en top sur R.id.item_list\n
>> si null
   alors création d'un fragment
>> sinon 2 cas :
   le fragment est une instance d'un fragment de details > donc il faut afficher le home en "< " pour pouvoir revenir sur le fragment de list
   sinon pas la peine, on met setHomeDisplayAsUpEnabled(false)


onOptionsItemSelected(MenuItem item)
gestion du clic sur android.R.id.home
    récupération d'une nouvelle transaction
    remplacement par un nouveau fragment de liste (pouvant être amélioré en sauvegardant, etc...)
    et commit
    enfin setHopeDisplayAsUpEnabled(false) >> reste néanmoins exploit de temps possible (avant transaction, mieux de faire une vérification du type comme dans le onCreate)
    
onBackPressed()
ajout du cas si on est en mode smartphone :
    récupération d'une nouvelle transaction si le fragment actuel est un ItemDetailFragment
    remplacement part un nouveau fragment de liste
    et commit
    puis le setHomeDisplayAsUpEnabled(false)

onItemSelected() (La méthode callback de l'activity)
modification du comportement de startActivity -> transaction de fragment
    puis le setHomeDisplayAsUpEnabled(true)
