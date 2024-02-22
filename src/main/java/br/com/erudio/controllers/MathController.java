package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import br.com.erudio.math.SimpleMath;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import static br.com.erudio.utils.DoubleConvert.convertToDouble;
import static br.com.erudio.utils.DoubleConvert.isNumeric;

@RestController

public class MathController {

	private static final AtomicLong counter = new AtomicLong();

	private final SimpleMath math = new SimpleMath();

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo) throws  Exception {

		if(!isNumeric(numberOne) || !isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("Please set a numeric value.");

		return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo) throws  Exception {

		if(!isNumeric(numberOne) || !isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("Please set a numeric value.");

		return math.subtraction( convertToDouble(numberOne), convertToDouble(numberTwo));
	}
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
							  @PathVariable(value = "numberTwo") String numberTwo) throws  Exception {

		if(!isNumeric(numberOne) || !isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("Please set a numeric value.");

		return math.multiplication( convertToDouble(numberOne) , convertToDouble(numberTwo));
	}
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable(value = "numberOne") String numberOne,
								 @PathVariable(value = "numberTwo") String numberTwo) throws  Exception {

		if(!isNumeric(numberOne) || !isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("Please set a numeric value.");

		return math.division( convertToDouble(numberOne) , convertToDouble(numberTwo));
	}
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}/{numberThree}", method = RequestMethod.GET)
	public Double mean(@PathVariable(value = "numberOne") String numberOne,
						   @PathVariable(value = "numberTwo") String numberTwo,
						  @PathVariable(value = "numberThree") String numberThree
						  ) throws  Exception {

		if(!isNumeric(numberOne) || !isNumeric(numberTwo) || !isNumeric(numberThree))
			throw new UnsupportedMathOperationException("Please set a numeric value.");


		return math.mean(convertToDouble(numberOne) , convertToDouble(numberTwo) , convertToDouble(numberThree));
	}

	@RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable(value = "number") String number) throws  Exception {

		if(!isNumeric(number))
			throw new UnsupportedMathOperationException("Please set a numeric value.");

		return math.squareRoot(convertToDouble(number));
	}



}
