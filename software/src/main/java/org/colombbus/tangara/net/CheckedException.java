/**
 * Tangara is an educational platform to get started with programming.
 * Copyright (C) 2008 Colombbus (http://www.colombbus.org)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.colombbus.tangara.net;

/**
 * An exception throwned already checked
 * 
 * @author gwen
 */
@SuppressWarnings("serial")
public class CheckedException extends Exception {

	/**
	 * Create a new exception without the 
	 */
	public CheckedException() {
		super();
	}

	/**
	 * @param message
	 */
	public CheckedException(String message) {
		super(message);
	}

	/**
	 * @param throwable
	 */
	public CheckedException(Throwable throwable) {
		super(throwable);
	}

	/**
	 * @param message
	 * @param throwable
	 */
	public CheckedException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
