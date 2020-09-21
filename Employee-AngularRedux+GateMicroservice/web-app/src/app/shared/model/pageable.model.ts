
export interface Pageable<T> {
  content: T[];
  pageNumber: number;
  size: number;
  totalPages: number;
}
