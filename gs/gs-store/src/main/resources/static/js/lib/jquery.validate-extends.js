/**
 * 
 */

jQuery.validator.addMethod("requiredNotEmpty", function(value, element) {   
    return '' != $.trim(value);
}, "This field is required not empty");