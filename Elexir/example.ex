defmodule Queue do

  def add() do {:queue, [], []} end

  def add({:queue, first, last}, elem) do {:Queue, first, [elem|last]} end

  def remove({:queue, [], []}) do :fail end
  def remove({:queue, [], last}) do
    [h|t] = :lists.reverse(last)
    {:ok, h, {:queue, t, []}}
  end
  def remove({:queue, [h|t], last}) do {:ok, h , {:queue, t, last}} end

  def app_queue({:queue, first1, last1}, {:queue, first2, last2}) do
    {:queue,:lists.append(first1, first2), :lists.append(last2,last1)}
  end
end

defmodule Tree do

    def in_tree(_, :nil) do :no end
    def in_tree(v, {:leaf, v}) do :yes end
    def in_tree(v, {:leaf, _}) do :no end
    def in_tree(v, {:node, v, _, _}) do :yes end
    def in_tree(v, {:node, _, left, right}) do
      case in_tree(v, left) do
        :yes -> :yes
        :no -> case in_tree(v, right) do
          :yes -> :yes
          :no -> :no
        end
      end
    end

    def compact({:leaf, n}) do {:leaf, n} end
    def compact({:node, {:leaf, n}, {:leaf, n}}) do {:leaf, n} end
    def compact({:node, :nil, {:leaf, n}}) do {:leaf, n} end
    def compact({:node, {:leaf, n}, :nil}) do {:leaf, n} end
    def compact({:node, left, right}) do
      {:node, compact(left), compact(right)}
    end
    
end
