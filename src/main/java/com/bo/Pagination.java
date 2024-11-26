package com.bo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {

	private Integer pageNumber;

	private Integer numPerPage;

	private String searchKey;

}
