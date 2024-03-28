import BasicMenu from "../components/menus/BasicMenu";

const BasicLayout = ({children}) => {
  return (
    <>
        <BasicMenu/>
        <header className="bg-[#4754C9] p-5 h-1/3">
            <h1 className="text-2xl md:text-2xl text-white">Header</h1>
        </header>
        <div className="bg-white">
            <main>
                {children}
            </main>
        </div>
    </>
  );
}

export default BasicLayout;
