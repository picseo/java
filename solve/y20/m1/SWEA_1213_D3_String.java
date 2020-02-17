package swea.D3;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA_1213_D3_String {

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res\\1213.txt"));
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		for(int t = 1; t <= 10; t++) {
			int i = sc.nextInt();
			String find = sc.next();
			String input = sc.next();
			int result = 0;
			
			while(input.indexOf(find) > -1) {
				i = input.indexOf(find);
				result++;
				///System.out.println(input);
				//System.out.println(result);
				input = input.substring(i+find.length());
				//System.out.println("sub : " + input);
			}
			
			System.out.println("#"+t+" "+result);
		}
	}

	private static String src = "1\r\n" + 
			"ti\r\n" + 
			"Starteatingwellwiththeseeighttipsforhealthyeating,whichcoverthebasicsofahealthydietandgoodnutrition\r\n" + 
			"2\r\n" + 
			"ing\r\n" + 
			"Thedoublehelixformsthestructuralbasisofsemi-conservativeDNAreplication.1,2Lessintuitively,italsohasimplicationsontheinformationcontentofDNAfordouble-strandedDNAassuchonlyhasabouthalfthestoragecapacityofsingle-strandedDNA.Thisisbecauseagivensequenceanditsreversecomplement,whilethesameinthedouble-strandedform,aredifferententitiesinsingle-strandedDNA?exceptforthosesequenceswhichareidenticaltotheirreversecomplement\r\n" + 
			"3\r\n" + 
			"th\r\n" + 
			"Lemierresyndromeiscausedbyaninfectionintheoropharyngealregionwithsubsequentthrombophlebitisintheinternaljugularvein.Thethrombusfromthethrombophlebitiscaninvadeothervitalorgans,suchasliver,lungs,orjoints,resultinginsecondaryinfection,whichfurtherexacerbatesthefatalprognosisofthissyndrome.Lemierresyndrome,alsocalledpostanginalsepsisornecrobacillosis,wasfirstreportedbyDr.Lemierrein1936.Inhisreport,Lemierrementionedthatoutof20patientswhosufferedfromthissyndrome,onlytwosurvived.Healsostatedthatallofthe20patientscomplainedofinfectionsinthepalatinetonsilsanddevelopedsepsisandthrombophlebitisintheinternaljugularvein.Oncecalleda\"forgottendisease,\"thissyndromeshowedaveryhighmortalityrateuntilusageofantibioticsbecameprevalent\r\n" + 
			"4\r\n" + 
			"tion\r\n" + 
			"Non-applicationdecreasedshootlengthandreducednumberofunnecessarysecondaryshootsby39%comparedwiththeconventionalrate,notaffectingyieldandweight,color,firmness,andsolublesolidsoffruits.Nosignificantdifferencewasalsofoundintheyieldandthefruitcharacteristicsamongthetreesfertilizedwithdifferentrates.Concentrationsofsolublesugars,starch,N,andKofdormantshootsinMarchofthefollowingyearwerenotsignificantlychangedbythedifferenttreatmentsofthepreviousyear.Therewasnosignificantdifferenceofshootgrowthandyieldamongthetreatmentsthefollowingyearwhenthesamefertilizationratewassuppliedtoallthetrees\r\n" + 
			"5\r\n" + 
			"to\r\n" + 
			"Duetoincreasedinterestincharactercostumes,thefieldofanimationcharactercostumedesignisgraduallydevelopingintoaspecializeddomain.Thecostume-makingprocessforanimationcharacterspresentsmanydifferencesfromthecostume-makingprocessforregularapparel.However,thereremainsinsufficientresearchontheactualprocessofmakingthecharactercostumesusedinstopmotionvideosbothinKoreaandabroad.Thepurposeofthisstudyistoestablishacostumedesignprocessforanimationcharacters.Furthermore,thisstudypresentsacasestudyonthecostumeplanningandmakingprocessfor3Dstopmotionanimationcharacters.Thecharactercostume-makingprocesswassegmentalizedintothefollowingstages:characteranalysisstage,charactermodelingstage,andcharactercostumemakingstage\r\n" + 
			"6\r\n" + 
			"by\r\n" + 
			"InKorea,noinstitutionaltoolorregulationexistsbywhicharetailbusinessinchargeofgatheringandmaintainingsubscriberscanbeguaranteedindependencefromthewholesalebusinessdivisionofafixedincumbentproviderofessentialfacilitiessuchasducts,polesandcopperorfibercables,whichmayalsobeofferingthesameproductstoitsrivals.Forthatreason,awholesaledivisionmayhaveanincentivetointentionallydisruptthesharingoffacilitiesrequestedbycompetitiveoperatorsincooperationwiththeretaildivision.Ultimately,thefacilitysharingprocesswillremaininactivewhenthereisalackofequivalentaccesstothefixedaccessnetwork\r\n" + 
			"7\r\n" + 
			"as\r\n" + 
			"Theaimofthisstudywastofindtypologyoffashion-relatedmobileapplicationsthroughexploratoryinvestigationandtoinvestigatedifferencesinKoreaandU.S.Appstores.Andthen,throughthequalitativeevaluationaboutfashionmobileapplications,thisstudyproposesfashionmobileapplication'sdesignandcontentswhichcanbepreferredbyusers.Byconductingkeywordsearchineachstore,122Koreanapplicationsand150USapplicationswereanalyzed.Empiricalfindingsrevealedthatthereweresevenmajortypesoffashionmobileapplications:brand,magazine,information,SNS,game,shoppingandcoordination.Informationtypeapplicationstookupthelargestportion,andSNSandgametypeapplicationsshowedhigherrankingamongcustomers\r\n" + 
			"8\r\n" + 
			"the\r\n" + 
			"rimaryvaricellainfectionusuellyrunsabenignclinicalcourseinthehelthypopulation.However,hemorrhagicchickenpoxpresentswithaveryextensiveeruptionofhemorrhagicvesiclesinpatientswithdecreaedplateletsorimpairedimmunityandisaccompaniedbysevereconstitutionalsymptoms.A7-year-oldmalewasadmiduetoabdompalpainfor1dayandpeneralizedvesiculareruptionfor5days.Theeruptionfirstappearedonthetrunkandthenspreadtoinvolvedface,scalpandextrsmities.Theskinrashwascompatablewithvaricellabutdespitetheadministrationofacclovirintravenously,thevesiculareruptionbecamehemorrhagic.Tendaysafteradmission,havingexperiencedcardiscarresttwiceandwithhismentalstateincoms,hewasdisehargedashissituationwashopelesa\r\n" + 
			"9\r\n" + 
			"of\r\n" + 
			"Thebookconsistsofthirteenchaptersinfiveparts.InthefirstpartHarmlessdescribessomeofthegeneralandreligiousbackgroundtofourth-andfifth-centuryEgypt,whichhelpstoplacewhatfollowsinabroadercontext.InhissecondparthediscussesAntonyandPachomius,althoughheacknowledgesthatAntonyisnotthehistoricalbeginningofmonasticism.HemovesnexttodiscusstheDesertFathers,exploringsomeofthetexts,characters,themes,locations,andhistories.Thisleadsthewayforreflectionsonthetheologyandworksoftwomonastictheologians,EvagriusPonticusandJohnCassian.Itmayseemoddatfirstglancethatthefinalsectionofthebook(?쁒eflections??shouldaddresstheoriginsofmonasticism,butHarmlessjustifiesthisfromhisexperienceasaneducator;peoplefinditeasiertoengagewithscholarlydiscussionsconcerningmonasticoriginsoncetheyarefamiliarwiththecharacters,texts,andthemes\r\n" + 
			"10\r\n" + 
			"es\r\n" + 
			"Intheinitialstage,domesticgamesbasedonlineconcentratedongamedevelopmentfocusingonincomeforsomegenres.However,variouscontentsfocusingonsmartenvironmentandsocialnetworkareexpandedatpresentandgamematerialsaredevelopedformorevariousobjects.So,thisstudyintendstoexaminenewcategory,positivegame,fromtheaspectofgamedesignerforgameapproachbasedonvariousobjects.And,gameapproachingprocessinthecategorybasedonpleasurewasorganizedfromthestandpointofdesigner,forthedesignerapproachintheprecedentstageofpositivegamedevelopment.Fromtheaspectofdesigner,systemicityofgamecategoryanddesignapproacharenecessarytoexpandwire-wirelessenvironmentandnewenvironmentbasedontheconvergencemediatointeractivecontentsfocusingongames\r\n" + 
			"";
}

