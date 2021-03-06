/*
 *
 * This is a simple Content Management System (CMS)
 * Copyright (C) 2010  Imran M Yousuf (imyousuf@smartitengineering.com)
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
package com.smartitengineering.cms.ws.common.domains;

import java.net.URI;
import java.util.Collection;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 *
 * @author imyousuf
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
public class SearchResult {

  private Collection<Content> result;
  private URI next;
  private URI previous;
  private int count;
  private int start;
  private long totalResults;

  public long getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(long totalResults) {
    this.totalResults = totalResults;
  }

  public int getCount() {
    return count;
  }

  public URI getNext() {
    return next;
  }

  public URI getPrevious() {
    return previous;
  }

  public Collection<Content> getResult() {
    return result;
  }

  public void setResult(Collection<Content> result) {
    this.result = result;
  }

  public int getStart() {
    return start;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public void setNext(URI next) {
    this.next = next;
  }

  public void setPrevious(URI previous) {
    this.previous = previous;
  }

  public void setStart(int start) {
    this.start = start;
  }
}
