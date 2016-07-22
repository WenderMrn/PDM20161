package br.edu.ifpb.si.pdm.analitico.util;


/**
 * Created by thor on 18/07/16.
 */
public class FormaterTextHelper {

        public static String Formater(Long age_value,Long age_range,Double gender_confidence,String gender_value, Double glass_confidence,
                                        String glass_value,String race_value,Double race_confidence,Double smiling_value){

            String text_info = "Essa pessoa tem entre %d e %d anos. Tenho  %.2f (por cento) de certeza que é do sexo %s, diria que tem" +
                    " %.2f (por cento) de chances dessa pessoa %s usando óculos. É %s e %s.";

            String smiling = "";
            if(smiling_value > 5 && smiling_value < 10){
                smiling = "está sorrindo enigmáticamente como a Mona Lisa";
            }else if(smiling_value <= 20){
                smiling = "está sorrindo muito discretamente";
            }else if(smiling_value <= 40){
                smiling = "está sorrindo levemente";
            }else if(smiling_value <= 60){
                smiling = "está sorrindo moderadamente";
            }else if(smiling_value <= 75){
                smiling = "está sorrindo bastante";
            }else if(smiling_value <= 85){
                smiling = "está sorrindo muito";
            }else if(smiling_value > 85){
                smiling = " está sorrindo escancaradamente";
            }else{
                smiling = "não está sorrindo";
            }

            if(gender_value.equalsIgnoreCase("male"))
                gender_value = "masculino";
            else
                gender_value = "feminino";

            if(glass_value.equalsIgnoreCase("none"))
                glass_value = " não está";
            else{
                glass_value = "está";
            }

            if(race_value.equalsIgnoreCase("black")){
                race_value = "negra";
            }else if(race_value.equalsIgnoreCase("white")){
                race_value = "branca";
            }else if(race_value.equalsIgnoreCase("asian")){
                race_value = "asiática";
            }

            return String.format(text_info,age_value,age_value+age_range,gender_confidence,gender_value,glass_confidence,glass_value,race_value,smiling);
    }

}
