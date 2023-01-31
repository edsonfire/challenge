/**
 * This is a sample chart export config file. It is provided as a reference on
 * how miscelaneous items in export menu can be used and set up.
 *
 * You do not need to use this file. It contains default export menu options 
 * that will be shown if you do not provide any "menu" in your export config.
 *
 * Please refer to README.md for more information.
 */


/**
 * PDF-specfic configuration
 */
AmCharts.exportPDF = {
	"format": "PDF",
	"content": [ "Saved from:", window.location.href, {
		"image": "reference",
		"fit": [ 523.28, 769.89 ] // fit image to A4
	} ]
};

/**
 * Print-specfic configuration
 */
AmCharts.exportPrint = {
	"format": "PRINT",
	"label": "Imprimir"
};

/**
 * Define main universal config
 */
AmCharts.exportCFG = {
	"enabled": true,
	"menu": [ {
		"class": "export-main",
		"label": "Export",
		"menu": [ {
			"label": "Baixar como ...",
			"menu": [ "PNG", "JPG", "SVG", AmCharts.exportPDF ]
		}, {
			"label": "Salvar ...",
			"menu": [ "CSV", "XLSX", "JSON" ]
		}, {
			"label": "Anotar",
			"action": "draw"
		}, AmCharts.exportPrint ]
	} ],

	"drawing": {
		"menu": [ {
			"class": "export-drawing",
			"menu": [ {
				"label": "Adicionar ...",
				"menu": [ {
					"label": "Texto",
					"action": "text"
				} ]
			}, {
				"label": "Alterar ...",
				"menu": [ {
					"label": "Ferramenta ...",
					"action": "draw.modes"
				}, {
					"label": "Cor ...",
					"action": "draw.colors"
				}, {
					"label": "Tamanho ...",
					"action": "draw.widths"
				}, {
					"label": "Transparencia...",
					"action": "draw.opacities"
				}, "UNDO", "REDO" ]
			}, {
				"label": "Baixar como...",
				"menu": [ "PNG", "JPG", "SVG", "PDF" ]
			}, "PRINT", "CANCEL" ]
		} ]
	}
};