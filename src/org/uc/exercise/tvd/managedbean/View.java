package org.uc.exercise.tvd.managedbean;

import java.io.UnsupportedEncodingException;

public interface View {
	String MDFCUSR = "/modificaUsuario.xhtml";
	String UNC = "/unchecker.xhtml";
	String LGN = "login.xhtml";
	String WDGT1 = "PF('widget1').show()";
	String WDGT2 = "PF('widget2').show()";
	String WDGT3 = "PF('widget3').show()";
	String WDGH3 = "PF('widget3').hide();";
	String FOOTER = "Universidad Cuauhtemoc. 2018";
	
	String NHD = "No existen datos para mostrar";
	String SUCCESS = "success";
	//Point: #40a038 #7d7db9
	//Line: #8dbc92 #616aed
	String JSON_CHARGE = 
	"particlesJS('particles-js',{"+
	"	\"particles\": {"+
	"	    \"number\": {"+
	"	    	\"value\": 200,"+
	"	      	\"density\": {"+
	"	        	\"enable\": true,"+
	"	        	\"value_area\": 789.1476416322727"+
	"	      	}"+
	"	     },"+
	"	    \"color\": {"+
	"	      	\"value\": \"#1E376D\""+
	"	     },"+
	"	    \"shape\": {"+
	"	     	\"type\": \"polygon\","+
	"	      	\"stroke\": {"+
	"	        	\"width\": 0,"+
	"	        	\"color\": \"#000000\""+
	"	      	 },"+
	"	      	\"polygon\": {"+
	"	        	\"nb_sides\": 5"+
	"	      	 },"+
	"	        \"image\": {"+
	"	        	\"src\": \"img/github.svg\","+
	"	        	\"width\": 100,"+
	"	        	\"height\": 100"+
	"	      	 }"+
	"	     },"+
	"	    \"opacity\": {"+
	"	      	\"value\": 0.5,"+
	"	      	\"random\": false,"+
	"	      	\"anim\": {"+
	"	        	\"enable\": false,"+
	"	        	\"speed\": 1,"+
	"	        	\"opacity_min\": 0.1,"+
	"	        	\"sync\": false"+
	"	      	 }"+
	"	     },"+
	"	    \"size\": {"+
	"	      	\"value\": 3,"+
	"	      	\"random\": true,"+
	"	      	\"anim\": {"+
	"	        	\"enable\": false,"+
	"	        	\"speed\": 40,"+
	"	        	\"size_min\": 0.1,"+
	"	        	\"sync\": false"+
	"	      	 }"+
	"	     },"+
	"	    \"line_linked\": {"+
	"	      	\"enable\": true,"+
	"	      	\"distance\": 150,"+
	"	      	\"color\": \"#616aed\","+
	"	      	\"opacity\": 0.4,"+
	"	      	\"width\": 1.1048066982851816"+
	"	     },"+
	"	    \"move\": {"+
	"	      	\"enable\": true,"+
	"	      	\"speed\": 6,"+
	"	      	\"direction\": \"none\","+
	"	      	\"random\": false,"+
	"	      	\"straight\": false,"+
	"	      	\"out_mode\": \"out\","+
	"	      	\"bounce\": false,"+
	"	      	\"attract\": {"+
	"	        	\"enable\": false,"+
	"	        	\"rotateX\": 600,"+
	"	        	\"rotateY\": 1200"+
	"	      	 }"+
	"	     }"+
	"	  },"+
	"	  \"interactivity\": {"+
	"	  	\"detect_on\": \"canvas\","+
	"	    \"events\": {"+
	"	    	\"onhover\": {"+
	"	        	\"enable\": true,"+
	"	        	\"mode\": \"repulse\""+
	"	      	 },"+
	"	        \"onclick\": {"+
	"	        	\"enable\": true,"+
	"	        	\"mode\": \"push\""+
	"	      	 },"+
	"	      	\"resize\": true"+
	"	     },"+
	"	    \"modes\": {"+
	"	    	\"grab\": {"+
	"	        	\"distance\": 400,"+
	"	        	\"line_linked\": {"+
	"	          		\"opacity\": 1"+
	"	        	 }"+
	"	      	 },"+
	"	      	\"bubble\": {"+
	"	        	\"distance\": 400,"+
	"	        	\"size\": 40,"+
	"	        	\"duration\": 2,"+
	"	        	\"opacity\": 8,"+
	"	        	\"speed\": 3"+
	"	      	 },"+
	"	      	\"repulse\": {"+
	"	        	\"distance\": 200,"+
	"	        	\"duration\": 0.4"+
	"	      	 },"+
	"	        \"push\": {"+
	"	        	\"particles_nb\": 4"+
	"	      	 },"+
	"	      	\"remove\": {"+
	"	        	\"particles_nb\": 2"+
	"	      	 }"+
	"	     }"+
	"	  },"+
	"    \"retina_detect\": true"+
	"	});";
}
